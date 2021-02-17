package mapol2000.helloandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // 변수선언시 초기화를 바로 못하는 경우 lateinit 키워드 사용
    lateinit var btnSayHello: Button
    lateinit var btnGoogle: Button
//    lateinit var btn911: Button
//    lateinit var btnGallery: Button
//    lateinit var btnFinish: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        // 안드로이드 앱의 실행 진입점
        // 즉, 현재 액티비티가 생성되면 뭔가를 실행하라는 의미

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        // 화면에 무언가를 출력함
        // res - layout - activity_main.xml

        btnSayHello = findViewById(R.id.btnSayHello)
        btnGoogle = findViewById(R.id.btnGoogle)
//        btn911 = findViewById(R.id.btn911)
//        btnGallery = findViewById(R.id.btnGallery)
//        btnFinish = findViewById(R.id.btnFinish)
        // activity_main.xml에서 id로 위젯을 찾아서 변수에 할당

        btnSayHello.setOnClickListener() { // btnSayHello에 클릭이벤트 추가
            Toast.makeText(applicationContext, "Hello, World!!", Toast.LENGTH_SHORT).show()
            // makeText(대상, 메세지, 지연시간).show() 잠시동안 메세지를 출력함
        }

        btnGoogle.setOnClickListener() {
            val gIntent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.co.kr"))
            startActivity(gIntent)
        } // 버튼 클릭시 새로운 브라우져 뷰를 열어서 구글 홈페이지를 띄움
    }

    // 특정 위젯을 findViewById 함수로 잡아서 이벤트를 추가할때마다 코드가 지저분해짐
    // 따라서, 이벤트 처리를 위한 독립적인 함수를 만들어 처리하는 것이 좋음
    // 레이아웃의 onClick 속성에 이벤트 처리함수를 지정하면 됨
    fun call911(v:View) {
        val cIntent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"))
        startActivity(cIntent)
    }

    fun openGallery(v:View) {
        val oIntent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"))
        startActivity(oIntent)
    }

    fun appFinish(v:View) {
        finish()
    }

}