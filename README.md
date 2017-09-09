## **Android Validator**

 Android validator is used for validating the user input using Annotation 

There are some Annotation are 

*  @Email //for email validation  
*  @Name  //for Name validation 
*  @Password // for Password min character length 8

With TextInputLayout and Custom Text

*  @Email(message = "please enter valid Email", til = R.id.tilEmail) //for email validation  
*  @Name(message = "please enter valid Name", til = R.id.tilName)  //for Name validation 
*  @Password(message = "please password", til = R.id.tilPassword) // for Password min character length 8 

//til is the id of TextInputLayout  

More are coming soon...

How to use?


Step 1:

Project Gradle 

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2:

Add the dependency

	dependencies {
	        compile 'com.github.harpzzz:Android-Validator:v0.2'
	}


Step 3:

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


    // Write this two line after all views are bind
    Validator validator = new Validator();
    validator.Validator(this);


## **License**
The MIT License (MIT)

Copyright 2017 Harpreet Singh

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## **Contact Us**

Personal : [Website](http://www.harpz.890m.com/)
