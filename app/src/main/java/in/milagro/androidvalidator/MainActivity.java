package in.milagro.androidvalidator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.harpz.androidvalidator.Validation.Validator;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Email;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Name;
import com.harpz.androidvalidator.Validation.validatorInterfaces.Password;

public class MainActivity extends AppCompatActivity {

    @Email
    private EditText etEmail;

    @Name
    private EditText etName;

    @Password
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.edEmail);
        etName = (EditText) findViewById(R.id.edName);
        etPassword = (EditText) findViewById(R.id.edPassword);

        Validator validator = new Validator();
        validator.Validator(this);

    }
}
