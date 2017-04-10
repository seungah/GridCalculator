package starbloom0128.kr.hs.emirim.editcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;

    Button[] butNums=new Button[10];
    Button[] butOps=new Button[4];
    public static final int SELECT_EDIT1=0;
    public static final int SELECT_EDIT2=1;
    int selectEdit=SELECT_EDIT1;
    String numStr=""; //초기화를 시켜줌

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1=(EditText)findViewById(R.id.but_edit1);
        edit2=(EditText)findViewById(R.id.but_edit2);
        edit1.setOnTouchListener(editHandler);
        edit2.setOnTouchListener(editHandler);

        for(int i=0; i<butNums.length; i++){
            butNums[i]=(Button)findViewById(R.id.but_num0+i);
            butNums[i].setOnClickListener(butNumHandler);

        }
        for(int i=0; i<butOps.length;i++){
            butOps[i]=(Button)findViewById(R.id.but_op1+i);
            butOps[i].setOnClickListener(butOpHandler);
        }
    }

    View.OnClickListener butNumHandler = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            Button but=(Button)view;
            numStr+= but.getText();
            switch (selectEdit){
                case SELECT_EDIT1:
                    edit1.setText(numStr);
                    break;
                case SELECT_EDIT2:
                    edit2.setText(numStr);

                    break;
            }
        }
    };
    View.OnClickListener butOpHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {



        }
    };
    View.OnTouchListener editHandler=new View.OnTouchListener(){
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent){
            switch(view.getId()){
                case R.id.but_edit1:
                    selectEdit = SELECT_EDIT1;
                    break;
                case R.id.but_edit2:
                    selectEdit = SELECT_EDIT2;
                    break;
            }
            return true;
        }
    };
}
