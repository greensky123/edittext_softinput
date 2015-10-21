package view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.RelativeLayout;

/**
 * Created by we on 10/15/15.
 */
public class SoftInputJustLayout extends RelativeLayout {
    private int width;

    private int height;

    private int screenHeight;

    private boolean sizeChanged = false;

    private OnSizeChangedListener onSizeChangedListener;

    public SoftInputJustLayout(Context context) {
        super(context);
        init(context);
    }


    public SoftInputJustLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SoftInputJustLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        DisplayMetrics dm=new DisplayMetrics();
       ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.width = widthMeasureSpec;
        this.height = heightMeasureSpec;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //监听不为空、宽度不变、当前高度与历史高度不为0
        if (this.onSizeChangedListener != null && w == oldw && h != 0 && oldh != 0) {
            if (h >= oldh ) {
                sizeChanged = false;
            } else  {
                sizeChanged = true;
            }
            this.onSizeChangedListener.onSizeChange(sizeChanged);
            measure(this.width - w + getWidth(), this.height - h + getHeight());
        }
    }


    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.onSizeChangedListener = onSizeChangedListener;
    }

    public abstract interface OnSizeChangedListener {
        public abstract void onSizeChange(boolean isChanged);
    }
}
