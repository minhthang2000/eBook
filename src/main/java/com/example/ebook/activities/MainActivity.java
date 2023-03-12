package com.example.ebook.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.ebook.R;
import com.example.ebook.adapter.CustomAdapter;
import com.example.ebook.model.Chapter;
import com.example.ebook.model.Topics;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    CustomAdapter customAdapter;
    List<Chapter> chapterList;
    List<Topics> topicsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView)findViewById(R.id.expandableListView);
        addData();


    }



    private void addData() {
        chapterList = new ArrayList<Chapter>();

        topicsList = new ArrayList<Topics>();
        topicsList.add(new Topics("360 Động Từ Bất Quy Tắc","360_dong_tu_bat_quy_tac.pdf"));
        topicsList.add(new Topics("3000 Từ Vựng Tiếng Anh Thông Dụng Nhất","3000_tu_vung_tieng_anh_thong_dung_nhat.pdf"));
        topicsList.add(new Topics("Tiếng Anh Ôn Thi Toeic","Tieng_anh_on_thi_Toeic.pdf"));
        topicsList.add(new Topics("Tự Học Tiếng Anh","Tu_hoc_tieng_anh.pdf"));
        chapterList.add(new Chapter("Tài Liệu Học Tiếng Anh", topicsList));

        topicsList = new ArrayList<Topics>();
        topicsList.add(new Topics("Machine Learning Cơ Bản","machine_learning_co_ban.pdf"));
        topicsList.add(new Topics("Giáo Trình C++ Cơ Bản Và Nâng Cao","Giao_Trinh_C_Can_Bn_Va_nang_Cao.pdf"));
        topicsList.add(new Topics("Python Cơ Bản","Python1088524.pdf"));
        topicsList.add(new Topics("Pro ASP.NET MVC 5","nhasachmienphi-pro-asp-net-mvc-5.pdf"));
        topicsList.add(new Topics("Công Nghệ Blockchain","nhasachmienphi-cong-nghe-blockchain.pdf"));
        topicsList.add(new Topics("Beginning Programming With Java For Dummies","nhasachmienphi-beginning-programming-with-java-for-dummies-4th-edition.pdf"));
        chapterList.add(new Chapter("Tài Liệu Công Nghệ Thông Tin", topicsList));

        topicsList = new ArrayList<Topics>();
        topicsList.add(new Topics("Truyện tranh Doremon - Tập 1","nhasachmienphi-truyen-tranh-doremon.pdf"));
        topicsList.add(new Topics("Ô Long Viện Siêu Buồn Cười – Trọn Bộ","nhasachmienphi-o-long-vien-sieu-buon-cuoi-tron-bo.pdf"));
        topicsList.add(new Topics("Người Hoá Hổ","nhasachmienphi-nguoi-hoa-ho.pdf"));
        topicsList.add(new Topics("Những Mảnh Đời Đen Trắng","nhasachmienphi-nhung-manh-doi-den-trang.pdf"));
        topicsList.add(new Topics("Làm Đĩ","nhasachmienphi-lam-di.pdf"));
        chapterList.add(new Chapter("Truyện Tranh - Tiểu Thuyết", topicsList));
        sendData();
    }

    private void sendData() {
        customAdapter=new CustomAdapter(chapterList, MainActivity.this);
        expandableListView.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.privacy:
                startActivity(new Intent(MainActivity.this, Privacy.class));
                break;
            case R.id.about:
                startActivity(new Intent(MainActivity.this, About.class));
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}