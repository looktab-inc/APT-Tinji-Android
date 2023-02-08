package com.looktab.tinji

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object DesignUtil {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.setImageUrl(url: String?) {
        url?.let {
            Glide.with(context)
                .load(it)
                .thumbnail(0.1f)
                .error(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_upload_img_default,
                        null
                    )
                )
                .placeholder(ColorDrawable(Color.parseColor("#DEE2E6")))
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("imageUrl200")
    fun ImageView.setImageUrl200(url: String?) {
        url?.let {
            Glide.with(context)
                .load(it)
                .override(200, 200)
                .thumbnail(0.1f)
                .placeholder(ColorDrawable(Color.parseColor("#DEE2E6")))
                .error(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_upload_img_default,
                        null
                    )
                )
                .into(this)
        }
    }

    @JvmStatic
    @BindingAdapter("imageUrl300")
    fun ImageView.setImageUrl300(url: String?) {
        url?.let {
            Glide.with(context)
                .load(it)
                .override(300, 300)
                .thumbnail(0.1f)
                .placeholder(ColorDrawable(Color.parseColor("#DEE2E6")))
                .error(
                    ResourcesCompat.getDrawable(
                        resources,
                        R.drawable.ic_upload_img_default,
                        null
                    )
                )
                .into(this)
        }
    }


    @JvmStatic
    @BindingAdapter("visibleGone")
    fun View.setVisibleGone(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("visibleInvisible")
    fun View.setVisibleInvisible(isVisible: Boolean) {
        visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }

    @JvmStatic
    fun dpToPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }


    @JvmStatic
    @BindingAdapter("walletGapTextColor")
    fun TextView.setWalletGapTextColor(gap: Double) {
        if (gap > 0) {
            setTextColor(this.resources.getColor(R.color.green))
        } else
            setTextColor(this.resources.getColor(R.color.red))
    }


    @JvmStatic
    @BindingAdapter("historyGapTextColor")
    fun TextView.setHistoryGapTextColor(string: String) {
        if (string.firstOrNull() == '+') {
            setTextColor(this.resources.getColor(R.color.green))
        } else
            setTextColor(this.resources.getColor(R.color.white))
    }

    @JvmStatic
    @BindingAdapter("historyType")
    fun TextView.setHistoryType(boolean: Boolean) {
        if (boolean) {
            setTextColor(this.resources.getColor(R.color.white))
            background = this.resources.getDrawable(R.drawable.box_r20_600)
        } else {
            setTextColor(this.resources.getColor(R.color.gray500))
            background = this.resources.getDrawable(R.drawable.box_r20_800)
        }
    }

    @JvmStatic
    @BindingAdapter("payType")
    fun ConstraintLayout.setPayType(boolean: Boolean) {
        if (boolean) {
            background = this.resources.getDrawable(R.drawable.card_pay_select)
        } else {
            background = this.resources.getDrawable(R.drawable.card_pay)
        }
    }

}