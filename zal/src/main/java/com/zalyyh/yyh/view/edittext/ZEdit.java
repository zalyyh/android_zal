package com.zalyyh.yyh.view.edittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;

import com.zalyyh.yyh.view.ViewArrt;
import com.zalyyh.yyh.zal.R;

public class ZEdit extends EditTextDelete {
    public ZEdit(Context context) {
        super(context);
    }

    public ZEdit(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ZEdit(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);

    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextDelete);
        digits = (String) ViewArrt.getobject("",a,R.styleable.EditTextDelete_digits);
        hint = (String) ViewArrt.getobject("",a,R.styleable.EditTextDelete_hint);
        textSize = a.getDimensionPixelSize(ViewArrt.getIntType(a,R.styleable.EditTextDelete_textSize),textSize);
        textColor = a.getColorStateList(ViewArrt.getIntType(a,R.styleable.EditTextDelete_textColor));
        gravity = (int)ViewArrt.getobject(-1,a,R.styleable.EditTextDelete_gravityz);
        lines = (int)ViewArrt.getobject(-1,a,R.styleable.EditTextDelete_lines);
        maxLength = (int)ViewArrt.getobject(-1,a,R.styleable.EditTextDelete_maxLength);
        maxLines = (int)ViewArrt.getobject(-1,a,R.styleable.EditTextDelete_maxLines);
        d = a.getDrawable(ViewArrt.getIntType(a,R.styleable.EditTextDelete_src));
       setAttrs();
    }


    /**
     * 设置图标点击事件
     *
     * @param l
     */
    public void setOnclick(OnClickListener l) {
        zImageView.setOnClickListener(l);
    }

    /**
     * 设置图标
     *
     * @param src
     */
    public void setSrc(int src) {
        zImageView.setImageResource(src);
    }

    public void setSrc(Drawable src) {
        zImageView.setImageDrawable(src);
    }

    public void setSrc(Bitmap src) {
        zImageView.setImageBitmap(src);
    }

    /**
     * 设置edit内容
     *
     * @param text
     */
    public void setEditText(String text) {
        if (text == null) text = "";
        zEditText.setText(text);
    }

    /**
     * 获取edit内容
     */
    public String getEditTextS() {
        return zEditText.getText().toString();
    }

    /**
     * 设置图标显示隐藏
     *
     * @param state
     */
    public void setVisible(int state) {
        setImageVisible(state);
    }

    /**
     * 设置图标无障碍内容
     *
     * @param text
     */
    public void setBarrierFree(String text) {
        zImageView.setContentDescription(text);
    }

    /**
     * 输入内容格式限制
     *
     * @param text 正则
     *             editText.setInputType(InputType.TYPE_CLASS_NUMBER); //输入类型
     *             editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)}); //最大输入长度
     *             editText.setTransformationMethod(PasswordTransformationMethod.getInstance()); //设置为密码输入框
     */
    public void setegEx(String text) {
        regEx = text;
    }

    /**
     * 输入内容长度限制
     *
     * @param
     */
    public void setMaxSize(int num) {
        zEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(num)}); //最大输入长度
    }
    /**
     * 设置提示文字
     *
     * @param
     */
    public void setHint(String text) {
        zEditText.setHint(text);
    }
    /**
     * 获取焦点
     */
    public boolean requeFocu() {
        zEditText.setFocusable(true);
        zEditText.setFocusableInTouchMode(true);
       return zEditText.requestFocus();
    }
    public EditText gete() {
        return zEditText;
    }
    public ImageView geti() {
        return zImageView;
    }
}
