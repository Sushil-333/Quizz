package com.example.techquiz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.techquiz.databinding.FragmentHomeBinding;
import com.example.techquiz.databinding.FragmentQuizBinding;
import com.example.techquiz.madelClass.QuizModel;

import java.util.ArrayList;
import java.util.Objects;


public class quizFragment extends Fragment {
    private int position=0;
    int right=0;
    private static String answer=null;
    String positionNo;
    QuizModel quizModel;
    String category,title;


    FragmentQuizBinding binding;
    ArrayList<QuizModel> list=new ArrayList<>();
    int allQuestion;
    String listSize;
    public quizFragment() {

    }
    public quizFragment(String category,String title) {
        this.category=category;
        this.title=title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentQuizBinding.inflate(getLayoutInflater());
        LoadQuestion();
        EnableOption();
        ClearOption();
        binding.nextBtn.setOnClickListener(v -> {
            position++;
            LoadQuestion();
            EnableOption();
            ClearOption();
            checkNext();

        });
        return binding.getRoot();
    }

    private void checkNext() {
        if(position==allQuestion){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.wrapper,new ResultFragment(right,allQuestion,category,title)).commit();
            list.clear();
            position=0;
        }
    }

    private void ClearOption() {
        binding.option1con.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option1con.setTextColor(getContext().getColor(R.color.black));
        binding.option2con.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option2con.setTextColor(getContext().getColor(R.color.black));
        binding.option3con.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option3con.setTextColor(getContext().getColor(R.color.black));
        binding.option4con.setBackgroundResource(R.drawable.sub_item_bg);
        binding.option4con.setTextColor(getContext().getColor(R.color.black));
        binding.nextBtn.setBackgroundResource(R.drawable.disable_btn);
    }

    private void EnableOption() {
        binding.option1con.setEnabled(true);
        binding.option2con.setEnabled(true);
        binding.option3con.setEnabled(true);
        binding.option4con.setEnabled(true);
        binding.nextBtn.setEnabled(false);
    }

    private void LoadQuestion() {
        switch (title) {
            case "C-School":
            list.add(new QuizModel("Who is the father of C language?", "Steve Jobs", "James Gosling", "Dennis Ritchie", "Rasmus Lerdorf", "Dennis Ritchie"));
            list.add(new QuizModel("Which of the following cannot be a variable name in C?", "volatile", "true", "export", "friend", "Volatile"));
            list.add(new QuizModel("Which of the following is not a valid C variable name?", " int number;", " float rate;", "int variable_count;", " int $main;", " int $main;"));
            list.add(new QuizModel("All keywords in C are in _____", "LowerCase letters", "UpperCase letters", "CamelCase letters", "None of the mentioned", "LowerCase letters"));
            list.add(new QuizModel("Which of the following is true for variable names in C?", "They can contain alphanumeric characters as well as special characters", "Variable names cannot start with a digit", "It is not an error to declare a variable to be one of the keyword", "Variable can be of any length", "Variable names cannot start with a digit"));
            setUp();
            break;
            case "C-Basic":
                list.add(new QuizModel("In which year was C language developed?", "1962", "1978", "1979", "1972", "1972"));
                list.add(new QuizModel("C language is a successor to which language?", "Basic", "C++", "Cobol", "B", "Cobol"));
                list.add(new QuizModel("C is a ___.", "Low level language", "High level language", "Medium level language", "None of the above", "Medium level language"));
                list.add(new QuizModel("How many keywords are there in C language?", "32", "33", "64", "18", "32"));
                list.add(new QuizModel(" C language is a ___.", "Procedural oriented programming language", "General purpose programming language", "Structured programming", "All of the above", "All of the above"));
                setUp();
                break;
            case "C-Easy":
                list.add(new QuizModel("What is an identifier in C language?", "An identifier is a combination of alphanumeric characters used for conditional and control statements", "An identifier is a combination of alphanumeric characters used for any variable, function, label name", "Both A and B", "None of the above", "An identifier is a combination of alphanumeric characters used for any variable, function, label name"));
                list.add(new QuizModel("A C-style comment, simply surround the text with ___.", "/* and */", "// and //", "//", "/** and **/", "/* and */"));
                list.add(new QuizModel("In which version of C language, the C++ Style comment (//) are introduced?", "C17", "C18", "C89", "C99", "C99"));
                list.add(new QuizModel("The C source file is processed by the ___.", "Interpreter", "Compiler", "Both A and B", "NOT", "Compiler"));
                list.add(new QuizModel("How many whitespace characters are allowed in C language?", "2", "3", "4", "5", "5"));

                setUp();
                break;
            case "C-Moderate":
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "\n" +
                        "int main()\n" +
                        "{\n" +
                        "    int x = 20;\n" +
                        "    x %= 3;\n" +
                        "    printf(\"%d\",x);\n" +
                        "\n" +
                        "    return 0;\n" +
                        "}", "2", "2.5", "Error", "Warning", "2"));
                list.add(new QuizModel("Which is/are the size qualifier(s) in C language?", "short", "long", "double", "Both A and B", "Both A and B"));
                list.add(new QuizModel("How many types of qualifiers are there in C language?", "2", "4", "3", "5", "3"));
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "\n" +
                        "int main()\n" +
                        "{\n" +
                        "    float x = 23.456;\n" +
                        "    printf(\"%.2f\",x);\n" +
                        "    return 0;\n" +
                        "}", "23.45600", "23.456", "23.45", "23.46", "23.46"));
                list.add(new QuizModel(" What is the difference between float and double in C?", "both are used for the same purpose", "double can store just double value as compare to float value", "double is an enhanced version of float and was introduced in C99", "double is more precise than float and can store 64 bits", "double is more precise than float and can store 64 bits"));
                setUp();
                break;
            case "C-Hard":
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "\n" +
                        "void main()\n" +
                        "{\n" +
                        "    int x = 10;\n" +
                        "    int y = x++ + 20;\n" +
                        "    \n" +
                        "    printf(\"%d,%d\",x,y);\n" +
                        "    \n" +
                        "    return 0;\n" +
                        "}", "11,30", "11,31", "10,30", "10,31", "11,30"));
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "\n" +
                        "int main()\n" +
                        "{\n" +
                        "    unsigned char c=290;\n" +
                        "    printf(\"%d\",c);\n" +
                        "    return 0;\n" +
                        "}", "290", "256", "34", "Garbage", "34"));
                list.add(new QuizModel("Which C keyword is used to extend the visibility of variables?", "extend", "extends", "extern", "auto", "extern"));
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "\n" +
                        "int main()\n" +
                        "{\n" +
                        "    char str1[] = { 'H', 'e', 'l', 'l', 'o' };\n" +
                        "    char str2[] = \"Hello\";\n" +
                        "\n" +
                        "    printf(\"%ld,%ld\", sizeof(str1), sizeof(str2));\n" +
                        "\n" +
                        "    return 0;\n" +
                        "}", "5,5", "6,6", "5,6", "NOT", "5,6"));
                list.add(new QuizModel("Let x is an integer array with three elements having value 10, 20, and 30. What will be the output of the following statement?\n" +
                        "\n" +
                        "printf(\"%u\",x);", "Prints the value of 0th element (i.e., 10)", "Prints the garbage value", "An error occurs", "Print the address of the array (i.e., the address of first (0th) element", "Print the address of the array (i.e., the address of first (0th) element"));
                setUp();
                break;
            case "CPP-School":
                list.add(new QuizModel(" How many keywords are in C++?", "32", "48", "99", "95", "95"));
                list.add(new QuizModel("Which of the following is not a valid keyword in C++ language?", "while", "for", "switch", "do-while", "do-while"));
                list.add(new QuizModel("In which year C++14 was introduced?", "2014", "2015", "2017", "NOT", "2014"));
                list.add(new QuizModel(" Which of the following is the correct extension of the C++ source code file?", ".cpp", ".c++", "Both", "None", ".cpp"));
                list.add(new QuizModel("Which of the following command is used for the C++ compiler in Linux OS?", "GCC", "c++", "g++", "None", "g++"));
                setUp();
                break;
            case "CPP-Basic":
                list.add(new QuizModel("OOPs stands for?", "Object Oriented Process System", "Object Oriented Programming System", "Object Oriented Programming Service", "Object Orientation Programming System", "Object Oriented Programming System"));
                list.add(new QuizModel("Which of the following header file is used to define cin, cout?", "<iomanip.h>", "<iostream.h>", "<fstream.h>", "NOT", "<iostream.h>"));
                list.add(new QuizModel("Which of the following is not a valid predefined object in C++?", "cin", "cout", "cput", "cerr", "cput"));
                list.add(new QuizModel("The stdout stands for ___.", "State Output", "Standard Output", "Stand Output", "Stream Output", "Standard Output"));
                list.add(new QuizModel("Which of the following is an insertion operator in C++?", ">>", "<<", "->", ">>>", "<<"));
                setUp();
                break;
            case "CPP-Easy":
                list.add(new QuizModel("The endl is a ___.", "Macro", "Object", "Pointer", "Function", "Macro"));
                list.add(new QuizModel("Which of the following object is also used to flush the stream?", "cin", "cout", "cerr", "endl", "endl"));
                list.add(new QuizModel("If we use value \"3.14\" then what will be the data type of the given value?", "float", "double", "long double", "NOT", "double"));
                list.add(new QuizModel("What is the size of a long double in C++?", "8 bytes", "10 bytes", "14 bytes", "16 bytes", "10 bytes"));
                list.add(new QuizModel("The operator '+' is?", "Unary Operator", "Binary Operator", "Both A and B", "None", "Both A and B"));
                setUp();
                break;
            case "CPP-Moderate":
                list.add(new QuizModel("Which of the following operator is a ternary operator?", "+=", "!=", "::", "?:", "?:"));
                list.add(new QuizModel("Which of the following operator is known as Referential Operator?", "!=", "?:", "->", "sizeof", "->"));
                list.add(new QuizModel("What will be the output of the following program?\n" +
                        "\n" +
                        "#include <iostream>\n" +
                        "using namespace std;\n" +
                        "\n" +
                        "void sayHello();\n" +
                        "{\n" +
                        "    cout << \"Hello World\";\n" +
                        "}\n" +
                        "\n" +
                        "int main()\n" +
                        "{\n" +
                        "    sayHello();\n" +
                        "    return 0;\n" +
                        "}", "Hello World", "Hello", "Error", "NOT", "Hello World"));
                list.add(new QuizModel("Which of the following is a more effective way to call a function with arguments?", "Call by value", "Call by reference", "Call by address", "None of the above", "Call by reference"));
                list.add(new QuizModel("Which of the following statement is correct about inline function?", "A function that is substituted at the place of call.", "A function that is called at compile time", "A function that contains only looping statements", "None of the above", "A function that is substituted at the place of call."));
                setUp();
                break;
            case "CPP-Hard":
                list.add(new QuizModel("When does a destructor gets called?", "When an object gets created", "When an object gets destroyed", "After calling constructor", "NOT", "When an object gets destroyed"));
                list.add(new QuizModel("What is the size of a far pointer?", "16-bit", "32-bit", "64-bit", "NOT", "32-bit"));
                list.add(new QuizModel("#include <stdio.h>\n" +
                        "int main()\n" +
                        "{\n" +
                        "    float* ptr = (int*)malloc(sizeof(float));\n" +
                        "    ptr = NULL;\n" +
                        "    free(ptr);\n" +
                        "}", "Memory leak", "Dangling pointer", "Compiler error", "None of the above", "Memory leak"));
                list.add(new QuizModel("Which programming language required heap memory allocation in the run time environment?", "A language that uses global variables", "A language that supports dynamic scoping", "A language that allows dynamic data structures", "A language that supports recursion", "A language that allows dynamic data structures"));
                list.add(new QuizModel("What is the size of an empty class in C++?", "1 Byte", "0 Byte", "2 Byte", "4 Byte", "1 Byte"));
                setUp();
                break;
            case "Java-School":
                list.add(new QuizModel("JDK stands for ____.", "Java development kit", "Java deployment kit", "JavaScript deployment kit", "NOT", "Java development kit"));
                list.add(new QuizModel("JRE stands for ___.", "Java run ecosystem", "JDK runtime Environment", "Java runtime Environment", "NOT", "Java runtime Environment"));
                list.add(new QuizModel("What makes the Java platform independent?", "Advanced programming language", "It uses bytecode for execution", "Class compilation", "All of these", "It uses bytecode for execution"));
                list.add(new QuizModel("What are the types of memory allocated in memory in java?", "Heap memory", "Stack memory", "Both A and B", "NOT", "Both A and B"));
                list.add(new QuizModel("Multiline comment is created using ___.", "//", "/* */", "<!--  -- >", "All of these", "/* */"));
                setUp();
                break;
            case "Java-Basic":
                list.add(new QuizModel("What is the entry point of a program in Java?", "main() method", "The first line of code", "Last line of code", "main class", "main() method"));
                list.add(new QuizModel("Which keyword in java is used for exception handling?", "excepHand", "excep", "throw", "All of these", "throw"));
                list.add(new QuizModel("Which class in Java is used to take input from the user?", "Scanner", "Input", "Applier", "NOT", "Scanner"));
                list.add(new QuizModel("Method used to take a string as input in Java?", "nextLine()", "next()", "Both A. and B", "NOT", "Both A. and B"));
                list.add(new QuizModel("Which of the following is the correct syntax to create a variable in Java?", "var name;", "int name;", "var name int;", "All of these", "int name;"));
                setUp();
                break;
            case "Java-Easy":
                list.add(new QuizModel("Question 1", "op1", "op2", "op3", "op4", "op2"));
                list.add(new QuizModel("Question 2", "op1", "op2", "op3", "op4", "op3"));
                list.add(new QuizModel("Question 3", "op1", "op2", "op3", "op4", "op2"));
                list.add(new QuizModel("Question 4", "op1", "op2", "op3", "op4", "op1"));
                list.add(new QuizModel("Question 5", "op1", "op2", "op3", "op4", "op2"));
                setUp();
                break;
            case "Java-Moderate":
                list.add(new QuizModel("Which of these is a type of variable in Java?", "Instance Variable", "Local Variable", "Static Variable", "All of these", "All of these"));
                list.add(new QuizModel("public class Main {\n" +
                        "  public static void main(String[] args) {\n" +
                        "    String str = \"Hello\";\n" +
                        "    str = \"Bye\";\n" +
                        "    System.out.println(str);\n" +
                        "  }\n" +
                        "}", "Hello", "Bye", "Error", "All of these", "Bye"));
                list.add(new QuizModel("What is type casting in Java?", "It is converting type of a variable from one type to another", "Casting variable to the class", "Creating a new variable", "All of these", "It is converting type of a variable from one type to another"));
                list.add(new QuizModel("Which type of casting is lossy in Java?", "Widening typecasting", "Narrowing typecasting", "Manual typecasting", "All of these", "Narrowing typecasting"));
                list.add(new QuizModel("public class Main {\n" +
                        "  public static void main(String arg[]) {\n" +
                        "    int i;\n" +
                        "    for (i = 1; i <= 12; i += 2) {\n" +
                        "      if (i == 8) {\n" +
                        "        System.out.println(i);\n" +
                        "        break;\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}", "1", "No output", "8", "1357911", "No output"));
                setUp();
                break;
            case "Java-Hard":
                list.add(new QuizModel("What is garbage collection in java?", "Method to manage memory in java", "Create new garbage values", "Delete all values", "All of these", "Method to manage memory in java"));
                list.add(new QuizModel("import java.util.Scanner;\n" +
                        "\n" +
                        "class ThisKeyword {\n" +
                        "  private int a = 4;\n" +
                        "  private int b = 1;\n" +
                        "\n" +
                        "  void getSum(int a, int b) {\n" +
                        "    this.a = a;\n" +
                        "    this.b = b;\n" +
                        "    System.out.println(this.a + this.b);\n" +
                        "  }\n" +
                        "}\n" +
                        "\n" +
                        "public class Main {\n" +
                        "  public static void main(String args[]) {\n" +
                        "    ThisKeyword T = new ThisKeyword();\n" +
                        "    T.getSum(3, 5);\n" +
                        "  }\n" +
                        "}", "5", "9", "8", "4", "8"));
                list.add(new QuizModel("Boxing is ___.", "Creating new box", "Creating object", "Converting primitive type of object instance", "All of these", "Converting primitive type of object instance"));
                list.add(new QuizModel("Which is the correct absolute path of a file in Java?", "C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\file_name.txt", "C:\\Program Files\\Java\\file_name.txt", "C:\\Program Files\\Java\\jdk1.8.0_131\\file_name.txt", "C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\File Handling\\file_name.txt", "C:\\Program Files\\Java\\jdk1.8.0_131\\bin\\file_name.txt"));
                list.add(new QuizModel("import java.util.Scanner;\n" +
                        "\n" +
                        "class ThisKeyword {\n" +
                        "  private int a = 4;\n" +
                        "  private int b = 1;\n" +
                        "\n" +
                        "  void getSum(int a, int b) {\n" +
                        "    this.a = a;\n" +
                        "    this.b = b;\n" +
                        "    System.out.println(this.a + this.b);\n" +
                        "  }\n" +
                        "}\n" +
                        "\n" +
                        "public class Main {\n" +
                        "  public static void main(String args[]) {\n" +
                        "    ThisKeyword T = new ThisKeyword();\n" +
                        "    T.getSum(3, 5);\n" +
                        "  }\n" +
                        "}", "Error", "8", "5", "NOT", "8"));
                setUp();
                break;
            case "Python-School":
                list.add(new QuizModel("Python is a ___object-oriented programming language.", "General purpose", "Special purpose", "Medium level programming language", "All of the mentioned above", "General purpose"));
                list.add(new QuizModel("Amongst the following, who is the developer of Python programming?", "Guido van Rossum", "Denis Ritchie", "Y.C. Khenderakar", "NOT", "Guido van Rossum"));
                list.add(new QuizModel("What is the maximum length of a Python identifier?", "32", "16", "128", "Not fixed", "Not fixed"));
                list.add(new QuizModel("In which year was the Python language developed?", "1995", "1972", "1981", "1989", "1989"));
                list.add(new QuizModel("In which language is Python written?", "English", "PHP", "C", "All of the above", "C"));
                setUp();
                break;
            case "Python-Basic":
                list.add(new QuizModel("Which one of the following is the correct extension of the Python file?", ".py", ".python", ".p", "NOT", ".py"));
                list.add(new QuizModel("In which year was the Python 3.0 version developed?", "2008", "2000", "2004", "2010", "2008"));
                list.add(new QuizModel("What do we use to define a block of code in Python language?", "Key", "Brackets", "Indentation", "NOT", "Indentation"));
                list.add(new QuizModel("Which character is used in Python to make a single line comment?", "/", "//", "#", "!", "#"));
                list.add(new QuizModel("Which of the following declarations is incorrect?", "_x = 2", "__x = 3", "__xyz__ = 5", "NOT", "NOT"));
                setUp();
                break;
            case "Python-Easy":
                list.add(new QuizModel("What is the method inside the class in python language?", "Object", "Function", "Attribute", "Argument", "Function"));
                list.add(new QuizModel("Which of the following is not a keyword in Python language?", "val", "raise", "try", "with", "val"));
                list.add(new QuizModel("Which of the following operators is the correct option for power(ab)?", "a ^ b", "a**b", "a ^ ^ b", "a ^ * b", "a**b"));
                list.add(new QuizModel("Which one of the following has the highest precedence in the expression?", "Division", "Subtraction", "Power", "Parentheses", "Parentheses"));
                list.add(new QuizModel("Which of the following functions is a built-in function in python language?", "val()", "print()", "println()", "NOT", "print()"));
                setUp();
                break;
            case "Python-Moderate":
                list.add(new QuizModel("pow(x,y,z)", "(x**y) / z", "(x / y) * z", "(x**y) % z", "(x / y) / z", "(x**y) % z"));
                list.add(new QuizModel("all([2,4,0,6])  \n" +
                        "What will be the output of this function?", "False", "Invalid code", "True", "0", "False"));
                list.add(new QuizModel("x = 1  \n" +
                        "while True:  \n" +
                        "    if x % 5 = = 0:  \n" +
                        "        break  \n" +
                        "    print(x)   \n" +
                        "    x + = 1 ", "error", "2 1", "0 3 1", "NOT", "error"));
                list.add(new QuizModel("Which one of the following syntaxes is the correct syntax to read from a simple text file stored in ''d:\\java.txt''?", "Infile = open(''d:\\\\java.txt'', ''r'')", "Infile = open(file=''d:\\\\\\java.txt'', ''r'')", "Infile = open(''d:\\java.txt'',''r'')", "Infile = open.file(''d:\\\\java.txt'',''r'')", "Infile = open(''d:\\\\java.txt'', ''r'')"));
                list.add(new QuizModel("x = ['XX', 'YY']  \n" +
                        "for i in a:  \n" +
                        "    i.lower()  \n" +
                        "print(a) ", "['XX', 'YY']", "['xx', 'yy']", "[XX, yy]", "NOT", "['XX', 'YY']"));
                setUp();
                break;
            case "Python-Hard":
                list.add(new QuizModel("import math  \n" +
                        "abs(math.sqrt(36)) ", "Error", "-6", "6", "6.0", "6.0"));
                list.add(new QuizModel("any([5>8, 6>3, 3>1])", "False", "True", "Invalid code", "None of these", "True"));
                list.add(new QuizModel(">>>\"a\"+\"bc\" ", "a+bc", "abc", "a bc", "a", "abc"));
                list.add(new QuizModel(">>> str1 = \"javat\"  \n" +
                        ">>> str2 = \":\"  \n" +
                        ">>> str3 = \"point\"  \n" +
                        ">>> str1[-1:]  ", "point", "t", "j", "java", "t"));
                list.add(new QuizModel("x = ['xy', 'yz']  \n" +
                        "for i in a:  \n" +
                        "    i.upper()  \n" +
                        "print(a)  ", "['xy', 'yz']", "['XY', 'YZ']", "[None, None]", "NOT", "['xy', 'yz']"));
                setUp();
                break;
            case "HTML/CSS-School":
                list.add(new QuizModel(" HTML is the standard ____language for creating Web pages.", "scripting", "programming", "styling", "markup", "markup"));
                list.add(new QuizModel("What is CSS stands for?", "Cascading Style Sheets", "Cascade Style Sheet", "Color Style Sheets", "Color Style Sheet", "Cascading Style Sheets"));
                list.add(new QuizModel("HTML stands for_______.", "Hyperactive Text Markup Language", "Hyper Text Markup Language", "Hyper Text Machine Language", "None of these", "Hyper Text Markup Language"));
                list.add(new QuizModel("What CSS describes?", "CSS describes how calculation perform on button click.", "CSS describes how HTML elements are to be displayed on screen, paper, or in other media", "Both A. and B.", "None of the above", "CSS describes how HTML elements are to be displayed on screen, paper, or in other media"));
                list.add(new QuizModel("Which is the correct syntax to include comment in an HTML document?", "//", "/* Comment */", "// Comment //", "<!-- Comment -->", "<!-- Comment -->"));
                setUp();
                break;
            case "HTML/CSS-Basic":
                list.add(new QuizModel("In a CSS file, there is a CSS rule for paragraphs tags – what does p can be called?", "Selector", "Attribute", "Property", "Tag", "Selector"));
                list.add(new QuizModel("Which element/tag defines a paragraph?", "<p>", "<pre>", "<panel>", "None of the above", "<p>"));
                list.add(new QuizModel("Which tag/element defines the HTML document's body?", "<HTML>", "<HTMLbody>", "<bdy>", "<body>", "<body>"));
                list.add(new QuizModel("Which tag is the root element of an HTML page?", "<html>", "<title>", "<head>", "<body>", "<html>"));
                list.add(new QuizModel("Internal styles are written within the _____ element.", "<style>…</style>", "<css>…</css>", "<stylesheet>…</stylesheet>", "Both A. and B", "<style>…</style>"));
                setUp();
                break;
            case "HTML/CSS-Easy":
                list.add(new QuizModel("Who invented HTML?", "Dave Raggett", "Tim Berners-Lee", "Denis Ritchie", "All of the above", "Tim Berners-Lee"));
                list.add(new QuizModel("HTML tags with no content are called _____.", "Special tags", "Advanced tags", "Empty tags", "Other tags", "Empty tags"));
                list.add(new QuizModel("CSS comments are placed within the ______.", "//", "/* and */", "<* and *>", "<! And !>", "/* and */"));
                list.add(new QuizModel("Which property is used to define the text color?", "text-color", "color", "font-color", "Both A and B", "color"));
                list.add(new QuizModel("HTML headings are defined with the _____ tags", "<head1> to <head6>", "<p1> to <p6>", "<h1> to <h6>", "<h1> to <h3>", "<h1> to <h6>"));
                setUp();
                break;
            case "HTML/CSS-Moderate":
                list.add(new QuizModel("Which is the correct HTML statement to define the red color of the paragraph text?", "<p style=\"color: #ff0000;\">", "<p style=\"color: red;\">", "Both A and B", "NOT", "Both A and B"));
                list.add(new QuizModel("From the given options which is/are the valid way to represent a color?", "A valid color name like \"blue\"", "HEX code like \"#0000ff\"", "RGB Value like \"rgb(0,0,255)", "All of the above", "All of the above"));
                list.add(new QuizModel("Which is the correct HTML statement to display H2O in a paragraph?", "<p>H<sup>2</sup>O</p>", "<p>H<ins>2</ins>O</p>", "<p>H<below>2</below>O</p>", "<p>H<sub>2</sub>O</p>", "<p>H<sub>2</sub>O</p>"));
                list.add(new QuizModel("Which HTML tag is used to define a short quotation?", "<quotation>", "<quote>", "<qut>", "<q>", "<q>"));
                list.add(new QuizModel("What is/are the correct value(s) of font-weight property?", "bold, italic, underline", "normal, bold, italic", "normal, bold, bolder, lighter, initial, and inherit", "NOT", "normal, bold, bolder, lighter, initial, and inherit"));
                setUp();
                break;
            case "HTML/CSS-Hard":
                list.add(new QuizModel("What HTML tag is used to define the contact information for the author/owner of a document or an article?", "<contact>", "<authorinfo>", "<address>", "<addr>", "<address>"));
                list.add(new QuizModel("Which CSS property is used to style the hyperlinks on hover (Mouse over)?", "a:mouseover", "a:move", "a:mover", "a:hover", "a:hover"));
                list.add(new QuizModel("Which tag is used to override the current text direction?", "<bdi>", "<bdo>", "<bdr>", "NOT", "<bdo>"));
                list.add(new QuizModel("Which is the correct CSS statement to define multiple font families?", "font: \"Times New Roman\", Times, serif;", "font-name: \"Times New Roman\", Times, serif;", "font-family: \"Times New Roman, Times, serif\";", "font-family: \"Times New Roman\", Times, serif;", "font-family: \"Times New Roman\", Times, serif;"));
                list.add(new QuizModel("Which CSS function uses the largest value?", "large()", "maximum()", "max_value()", "max()", "max()"));
                setUp();
                break;

        }

    }
    private void setUp(){
        allQuestion=5;
        listSize=String.valueOf(allQuestion);
        binding.totalQ.setText("/"+listSize);

        if(position!=allQuestion){
            positionNo=String.valueOf(position+1);
            binding.qNo.setText(positionNo);
        }else{
            positionNo=String.valueOf(position);
            binding.qNo.setText(positionNo);
        }
        quizModel=list.get(position);
        answer=quizModel.getCorrectAns();
        binding.questionCon.setText(quizModel.getQuestion());
        binding.option1con.setText(quizModel.getOp1());
        binding.option2con.setText(quizModel.getOp2());
        binding.option3con.setText(quizModel.getOp3());
        binding.option4con.setText(quizModel.getOp4());
        optionCheckUp();
    }


    private void optionCheckUp() {
        binding.option1con.setOnClickListener(v ->{
            if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
                right++;
                binding.option1con.setBackgroundResource(R.drawable.right_bg);
                binding.option1con.setTextColor(getContext().getColor(R.color.white));
            }else{
                showRightAns();
                binding.option1con.setBackgroundResource(R.drawable.wrong_bg);
                binding.option1con.setTextColor(getContext().getColor(R.color.white));
            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.option2con.setOnClickListener(v ->{
            if(Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
                right++;
                binding.option2con.setBackgroundResource(R.drawable.right_bg);
                binding.option2con.setTextColor(getContext().getColor(R.color.white));
            }else{
                showRightAns();
                binding.option2con.setBackgroundResource(R.drawable.wrong_bg);
                binding.option2con.setTextColor(getContext().getColor(R.color.white));
            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.option3con.setOnClickListener(v ->{
            if(Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
                right++;
                binding.option3con.setBackgroundResource(R.drawable.right_bg);
                binding.option3con.setTextColor(getContext().getColor(R.color.white));
            }else{
                showRightAns();
                binding.option3con.setBackgroundResource(R.drawable.wrong_bg);
                binding.option3con.setTextColor(getContext().getColor(R.color.white));
            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
        binding.option4con.setOnClickListener(v ->{
            if(Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
                right++;
                binding.option4con.setBackgroundResource(R.drawable.right_bg);
                binding.option4con.setTextColor(getContext().getColor(R.color.white));
            }else{
                showRightAns();
                binding.option4con.setBackgroundResource(R.drawable.wrong_bg);
                binding.option4con.setTextColor(getContext().getColor(R.color.white));
            }
            DisableOption();
            binding.nextBtn.setBackgroundResource(R.drawable.item_bg);
        });
    }

    private void DisableOption() {
        binding.option1con.setEnabled(false);
        binding.option2con.setEnabled(false);
        binding.option3con.setEnabled(false);
        binding.option4con.setEnabled(false);
        binding.nextBtn.setEnabled(true);
    }

    private void showRightAns() {
        if(Objects.equals(quizModel.getOp1(),quizModel.getCorrectAns())){
            binding.option1con.setBackgroundResource(R.drawable.right_bg);
            binding.option1con.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp2(),quizModel.getCorrectAns())){
            binding.option2con.setBackgroundResource(R.drawable.right_bg);
            binding.option2con.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp3(),quizModel.getCorrectAns())){
            binding.option3con.setBackgroundResource(R.drawable.right_bg);
            binding.option3con.setTextColor(getContext().getColor(R.color.white));
        }else if(Objects.equals(quizModel.getOp4(),quizModel.getCorrectAns())){
            binding.option4con.setBackgroundResource(R.drawable.right_bg);
            binding.option4con.setTextColor(getContext().getColor(R.color.white));
        }
    }
}