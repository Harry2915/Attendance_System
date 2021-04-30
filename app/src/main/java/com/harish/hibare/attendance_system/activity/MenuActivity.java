package com.harish.hibare.attendance_system.activity;

import java.util.ArrayList;

import com.harish.hibare.attendance_system.bean.AttendanceBean;
import com.harish.hibare.attendance_system.context.ApplicationContext;
import com.harish.hibare.attendance_system.db.DBAdapter;
import com.harish.hibare.attendance_system.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MenuActivity extends Activity {

	RelativeLayout addStudent;
	RelativeLayout addFaculty;
	RelativeLayout viewStudent;
	RelativeLayout viewFaculty;
	RelativeLayout logout;
	RelativeLayout attendancePerStudent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		addStudent =(RelativeLayout)findViewById(R.id.buttonaddstudent);
		addFaculty =(RelativeLayout)findViewById(R.id.buttonaddfaculty);
		viewStudent =(RelativeLayout)findViewById(R.id.buttonViewstudent);
		viewFaculty =(RelativeLayout)findViewById(R.id.buttonviewfaculty);
		logout =(RelativeLayout)findViewById(R.id.buttonlogout);
		
		addStudent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,AddStudentActivity.class);
				startActivity(intent);
			}
		});
		
		addFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,AddFacultyActivity.class);
				startActivity(intent);
			}
		});
		
		viewFaculty.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,ViewFacultyActivity.class);
				startActivity(intent);
			}
		});


		viewStudent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,ViewStudentActivity.class);
				startActivity(intent);
			}
		});
		logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent =new Intent(MenuActivity.this,MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
		attendancePerStudent=(RelativeLayout)findViewById(R.id.attendancePerStudentButton);
		attendancePerStudent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				DBAdapter dbAdapter = new DBAdapter(MenuActivity.this);
				ArrayList<AttendanceBean> attendanceBeanList=dbAdapter.getAllAttendanceByStudent();
				((ApplicationContext)MenuActivity.this.getApplicationContext()).setAttendanceBeanList(attendanceBeanList);
				
				Intent intent = new Intent(MenuActivity.this,ViewAttendancePerStudentActivity.class);
				startActivity(intent);
				
			}
		});
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
