package amrita.design.com.amritanavigator;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;

public class DrawView extends View {
    private static int DRAG = 1;
    private static final float MAX_ZOOM = 2.5f;
    private static int NONE = 0;
    private static final String TAG = "map";
    private static int ZOOM = 2;
    private float MIN_ZOOM = 1.0f;
    float[] arr;

    Bitmap bitmap,bit2;
    Paint col = new Paint();
    private boolean dragged;
    private int height;
    public float mScaleFactor = 1.0f;
    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleListener mScaleGestureListener;
    private int mode;
    Paint paint = new Paint();
    Paint paint2=new Paint();
    private float previousTranslateX = 0.0f;
    private float previousTranslateY = 0.0f;
    private float startX = 0.0f;
    private float startY = 0.0f;
    private float translateX = 0.0f;
    private float translateY = 0.0f;
    private int width;
public float a,b;

    private class ScaleListener extends SimpleOnScaleGestureListener {
        private ScaleListener() {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            DrawView drawView = DrawView.this;
            drawView.mScaleFactor *= drawView.mScaleGestureDetector.getScaleFactor();
            drawView = DrawView.this;
            drawView.mScaleFactor = Math.max(drawView.MIN_ZOOM, Math.min(DrawView.this.mScaleFactor, DrawView.MAX_ZOOM));
            Log.d(DrawView.TAG, Float.toString(DrawView.this.mScaleFactor));
            DrawView.this.invalidate();
            return true;
        }
    }

    private void init() {
        int random = (int) (Math.random() * 255.0d);
        int random2 = (int) (Math.random() * 255.0d);
        int random3 = ((int) (Math.random() * 255.0d)) + 100;
        if ((random + random3) + random2 > 720) {
            random -= 50;
        }
        this.paint.setColor(Color.rgb(random, random2, random3));
        this.paint2.setColor(Color.rgb(0,0,0));
        this.paint.setStrokeWidth(5.0f);
        this.col.setColor(Color.rgb(0, 0, 120));
        this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mafff);
        this.bit2=BitmapFactory.decodeResource(getResources(),R.drawable.map);
        this.width = 1080;
        random2 = this.width;
        this.height = (random2 * 1040) / 1080;
        this.bitmap = Bitmap.createScaledBitmap(this.bitmap, random2, this.height, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.mode = DRAG;
                this.startX = motionEvent.getX() - this.previousTranslateX;
                this.startY = motionEvent.getY() - this.previousTranslateY;
                break;
            case 1:
                this.mode = NONE;
                this.dragged = false;
                this.previousTranslateX = this.translateX;
                this.previousTranslateY = this.translateY;
                break;
            case 2:
                this.translateX = motionEvent.getX() - this.startX;
                this.translateY = motionEvent.getY() - this.startY;
                if (Math.sqrt(Math.pow((double) (motionEvent.getX() - (this.startX + this.previousTranslateX)), 2.0d) + Math.pow((double) (motionEvent.getY() - (this.startY + this.previousTranslateY)), 2.0d)) > 0.0d) {
                    this.dragged = true;
                    break;
                }
                break;
            case 5:
                this.mode = ZOOM;
                break;
            case 6:
                this.mode = DRAG;
                this.previousTranslateX = this.translateX;
                this.previousTranslateY = this.translateY;
                break;
        }
        this.mScaleGestureDetector.onTouchEvent(motionEvent);
        this.mScaleGestureListener.onScale(this.mScaleGestureDetector);
        if ((this.mode == DRAG && this.mScaleFactor != 1.0f && this.dragged) || this.mode == ZOOM) {
            invalidate();
        }
        return true;
    }

    public DrawView(Context context, float[] fArr) {
        super(context);
        this.arr = fArr;
        init();
        this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleListener());
        this.mScaleGestureListener = new ScaleListener();
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DrawView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void onDraw(Canvas canvas) {
        float f;
        Coordinates coordinates = new Coordinates();
        Canvas canvas2 = canvas;



        super.onDraw(canvas);
        canvas.save();
        float f2 = this.mScaleFactor;
        canvas2.scale(f2, f2);
        f2 = this.translateX;
        if (f2 * -1.0f < 0.0f) {
            this.translateX = 0.0f;
        } else if (f2 * -1.0f > ((this.mScaleFactor - 1.0f) * ((float) getWidth())) - 20.0f) {
            this.translateX = (1.0f - this.mScaleFactor) * 1080.0f;
        }
        f2 = this.translateY;
        if (f2 * -1.0f < 0.0f) {
            this.translateY = 0.0f;
        } else {
            f2 *= -1.0f;
            f = this.mScaleFactor;
            if (f2 > (f - 1.0f) * 1080.0f) {
                this.translateY = (1.0f - f) * 1080.0f;
            }
        }
        f2 = this.translateX;
        f = this.mScaleFactor;
        canvas2.translate(f2 / f, this.translateY / f);
        canvas2.drawBitmap(this.bitmap, 0.0f, 0.0f, null);
        Distance distance = new Distance();

        String inte = distance.inte(this.arr[0]);
        setTextSizeForWidth(this.col, 350.0f, inte);
        canvas2.drawText(inte, 50.0f, 1000.0f, this.col);

        Log.i("add",Float.toString(a));
        Log.i("badd",Float.toString(b));
int i=1;
       while (true) {
            float[] fArr = this.arr;
            int i2 = i + 1;
            if (fArr[i2] != 0.0f) {
                if (!(fArr[i2] == 87.0f || fArr[i] == 87.0f)) {
                    float[][] fArr2 = coordinates.coord;
                    canvas.drawLine(fArr2[((int) fArr[i]) - 1][0], fArr2[((int) fArr[i]) - 1][1], fArr2[((int) fArr[i2]) - 1][0], fArr2[((int) fArr[i2]) - 1][1], this.paint);
                   // canvas2.drawCircle(pointarr[len-1],pointarr[len-1],5.0f, this.paint);
                  a=fArr2[((int) fArr[i2]) - 1][0]-15.0f;
                  b=fArr2[((int) fArr[i2]) - 1][1]-20.0f;

                  //  canvas.drawCircle( fArr2[j+1][0], fArr2[j+1][1], 10.0f,this.paint2);
                }

                i = i2;

            } else {
              //  Log.i("elseadd",Float.toString(a));
              //  Log.i("elsebadd",Float.toString(b));
             //   canvas.drawCircle(a,b,10.0f,this.paint2);
                Log.d("cood", Float.toString(a));
                canvas.drawBitmap(bit2,a,b,this.paint2);

                canvas.restore();

                return;
            }
        }


    }

    private static void setTextSizeForWidth(Paint paint, float f, String str) {
        paint.setTextSize(1000.0f);
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        paint.setTextSize((f * 1000.0f) / ((float) rect.width()));
    }






}
