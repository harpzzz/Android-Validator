package in.milagro.androidvalidator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.harpz.androidvalidator.Validator;
import com.harpz.androidvalidator.ValidatorListener;
import com.harpz.androidvalidator.validatorAnnotations.Checked;
import com.harpz.androidvalidator.validatorAnnotations.Email;
import com.harpz.androidvalidator.validatorAnnotations.Name;
import com.harpz.androidvalidator.validatorAnnotations.Password;
import com.harpz.androidvalidator.validatorAnnotations.RadioCheck;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ValidatorListener {

    @Email(til = R.id.tilEmail)
    private EditText etEmail;

    @Name(message = "Name is not valid", til = R.id.tilName)
    private EditText etName;

    @Password(message = "Name is not valid", til = R.id.tilPassword)
    private EditText etPassword;

    @Checked
    private CheckBox checkbox;

    @RadioCheck
    private RadioGroup radioGroup;



    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.edEmail);
        etName = (EditText) findViewById(R.id.edName);
        etPassword = (EditText) findViewById(R.id.edPassword);

        final Validator validator = new Validator(this);


        radioGroup = (RadioGroup) findViewById(R.id.rg);

        checkbox = (CheckBox) findViewById(R.id.checkbox);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
            }
        });

    }

    @Override
    public void onValidateSuccess() {
        Toast.makeText(this, "All Validate properly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidateFailed(ArrayList list) {

    }
}
