package com.zalyyh.yyh.zal.view.edittext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint("AppCompatCustomView")
public class EditTextDelete extends LinearLayout implements TextWatcher {
    protected EditText zEditText;
    protected ImageView zImageView;
    protected LinearLayout.LayoutParams zEditLp;
    protected LinearLayout.LayoutParams zImageLp;
    private int zimage_state = 0;
    protected String regEx = "";
    public EditTextDelete(Context context) {
        this(context,null);
    }
    public EditTextDelete(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,android.R.attr.editTextStyle);
    }
    public EditTextDelete(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    private void init(Context context) {
        getzEditText(context);
        getzImageView(context);
        removeAllViews();
        addView(zEditText);
        addView(zImageView);
        setImageVisible();
    }
    private void getzImageView(Context context){
        zImageView = new ImageView(context);
        zImageLp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        zImageLp.rightMargin=20;
        zImageView.setLayoutParams(zImageLp);
    }
    private void getzEditText(Context context){
        zEditText = new EditText(context);
        zEditLp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT, (float) 1.0);
        zEditText.setLayoutParams(zEditLp);
        zEditText.setBackgroundColor(Color.parseColor("#00000000"));
        zEditText.addTextChangedListener(this);
    }
    /**
     * 设置清除图标的显示与隐藏，
     * @param state
     */
    protected void setImageVisible(int state) {
        zimage_state = 1;
        zImageView.setVisibility(state);
    }
    private void setImageVisible() {
        if(zimage_state != 0)return;
        zImageView.setVisibility(zEditText.getText().toString().length()>0?VISIBLE:GONE);
    }
    public void setzImageView(ImageView imageView){
        zImageView = imageView;
    }
    public void setzEditText(EditText editText){
        zEditText = editText;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if(regEx!=null&&!regEx.isEmpty()) {
            String editable = zEditText.getText().toString();
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(editable);
            String str = m.replaceAll("").trim();    //删掉不是字母或数字的字符
            if (!editable.equals(str)) {
                zEditText.setText(str);  //设置EditText的字符
                zEditText.setSelection(str.length()); //因为删除了字符，要重写设置新的光标所在位置
            }
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
        setImageVisible();
    }
}
