package com.lucc.jdlite.activity

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Vibrator
import com.lucc.jdlite.BaseActivity
import com.lucc.jdlite.R
import kotlinx.android.synthetic.main.activity_about.*


class AboutActivity : BaseActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_about
    }

    override fun initView() {
        setTitle("关于软件")
    }

    override fun initData() {
    }

    override fun setEvent() {


        addQQGroup.setOnClickListener {
            joinQQGroup("yaLUQPBVq6i6wL4rpd-RGzF3GmmLLcsa")
        }

        github.setOnClickListener {
            joinQQ("1832649614")
        }
//        github.setOnClickListener {
//            val intent = Intent(this, MyWebActivity::class.java)
//            intent.putExtra("url", "http://wpa.qq.com/msgrd?v=3&uin=1832649614&site=qq&menu=yes")
//            intent.putExtra("title", "京豆小部件——GitHub")
//            startActivity(intent)
//            val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//            vibrator.vibrate(10)
//        }
        btn1.setOnClickListener {
            val intent = Intent(this, MyWebActivity::class.java)
            intent.putExtra("url", "http://101.33.239.32:1314/down/km148TlpsTFf")
            intent.putExtra("title", "京豆小部件——版本更新")
            startActivity(intent)
            val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(10)
        }
        lucc.setOnClickListener {
            val intent = Intent(this, MyWebActivity::class.java)
            intent.putExtra("url", "lucc.work")
            intent.putExtra("title", "暂时没想到换什么")
            startActivity(intent)
            val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            vibrator.vibrate(10)
        }
    }

    fun joinQQGroup(key: String): Boolean {
        val intent = Intent()
        intent.data =
            Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D$key")
        return try {
            startActivity(intent)
            true
        } catch (e: java.lang.Exception) {
            false
        }
    }

    /**
     * 跳转QQ聊天界面
     */
    fun joinQQ(key: String): Boolean {
        val intent = Intent()
        intent.data =
                //第二种方式：可以跳转到添加好友，如果qq号是好友了，直接聊天
            Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=$key") //uin是发送过去的qq号码
        return try {
            startActivity(intent)
            true
        } catch (e: java.lang.Exception) {
            false
        }
    }

}