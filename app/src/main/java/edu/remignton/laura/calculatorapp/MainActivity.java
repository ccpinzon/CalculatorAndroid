package edu.remignton.laura.calculatorapp;

import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MAINCALC";
    private Button _btnOne;
    private Button _btnTwo;
    private Button _btnThree;
    private Button _btnDiv;
    private Button _btnFour;
    private Button _btnFive;
    private Button _btnSix;
    private Button _btnMult;
    private Button _btnSeven;
    private Button _btnEigth;
    private Button _btnNine;
    private Button _btnRest;
    private Button _btnCero;
    private Button _btnCeroCero;
    private Button _btnSum;
    private Button _btnEquals;
    private Button _btnClear;

    private EditText _editCalc;

    private int _value;
    private int _operation;

    private boolean _newValue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _value = 0;

        _editCalc = (EditText) findViewById(R.id.editTextCalc);
        _btnClear =(Button) findViewById(R.id.btn_Clear);
        _btnOne = (Button) findViewById(R.id.btn_One);
        _btnTwo = (Button) findViewById(R.id.btn_Two);
        _btnThree =(Button) findViewById(R.id.btn_Three);
        _btnDiv =(Button) findViewById(R.id.btn_Div);
        _btnFour =(Button) findViewById(R.id.btn_Four);
        _btnFive =(Button) findViewById(R.id.btn_Five);
        _btnSix =(Button) findViewById(R.id.btn_Six);
        _btnMult =(Button) findViewById(R.id.btn_Mult);
        _btnSeven =(Button) findViewById(R.id.btn_Seven);
        _btnEigth =(Button) findViewById(R.id.btn_Eigth);
        _btnNine =(Button) findViewById(R.id.btn_Nine);
        _btnRest =(Button) findViewById(R.id.btn_Rest);
        _btnCero = (Button) findViewById(R.id.btn_Cero);
        _btnCeroCero =(Button) findViewById(R.id.btn_CeroCero);
        _btnSum = (Button) findViewById(R.id.btn_Sum);
        _btnEquals =(Button) findViewById(R.id.btn_equals);

        _editCalc.setText("0");

        View.OnClickListener lsButtonsNumbers =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _editCalc.setTextColor(Color.BLACK);
                changeValue();
                _editCalc.setText(_editCalc.getText()+((Button)view).getText().toString());
            }
        };

        View.OnClickListener lsButtonsOperations =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toCalc();
                _operation = 0;
                _newValue = true;
                String text = ((Button)view).getText().toString();
                if (text.equals("+")) _operation = 0;
                if (text.equals("-")) _operation = 1;
                if (text.equals("*")) _operation = 2;
                if (text.equals("/")) _operation = 3;
                if (text.equals("=")) _operation = -1;
            }
        };

        _btnOne.setOnClickListener(lsButtonsNumbers);
        _btnTwo.setOnClickListener(lsButtonsNumbers);
        _btnThree.setOnClickListener(lsButtonsNumbers);
        _btnFour.setOnClickListener(lsButtonsNumbers);
        _btnFive.setOnClickListener(lsButtonsNumbers);
        _btnSix.setOnClickListener(lsButtonsNumbers);
        _btnSeven.setOnClickListener(lsButtonsNumbers);
        _btnEigth.setOnClickListener(lsButtonsNumbers);
        _btnNine.setOnClickListener(lsButtonsNumbers);
        _btnCero.setOnClickListener(lsButtonsNumbers);
        _btnCeroCero.setOnClickListener(lsButtonsNumbers);

        _btnSum.setOnClickListener(lsButtonsOperations);
        _btnRest.setOnClickListener(lsButtonsOperations);
        _btnMult.setOnClickListener(lsButtonsOperations);
        _btnDiv.setOnClickListener(lsButtonsOperations);
        _btnEquals.setOnClickListener(lsButtonsOperations);

        _btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                _editCalc.setText("0");
                _newValue = true;
                _operation = -1;
            }
        });


    }

    private void toCalc() {
        switch (_operation){
            case -1:
                _value = Integer.parseInt(_editCalc.getText().toString());
                break;
            case 0: //suma
                _value = _value + Integer.parseInt(_editCalc.getText().toString());
                _editCalc.setText(String.valueOf(_value));
                break;
            case 1: // resta
                _value = _value - Integer.parseInt(_editCalc.getText().toString());
                _editCalc.setText(String.valueOf(_value));
                break;
            case 2: //Mutiplicacion
                _value = _value * Integer.parseInt(_editCalc.getText().toString());
                _editCalc.setText(String.valueOf(_value));
                break;
            case 3: // Division
                try {
                    _value = _value / Integer.parseInt(_editCalc.getText().toString());
                    _editCalc.setText(String.valueOf(_value));
                }catch (Exception e){
                    _editCalc.setTextColor(Color.RED);
                    _editCalc.setText("Error");
                }
                break;
        }

    }

    private void changeValue() {
        if (_newValue){
            _editCalc.setText("");
            _newValue = false;
        }
    }
}
