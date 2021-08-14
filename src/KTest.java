import java.util.*;

public class KTest {

    // First.Last@email.com
    // 하이픈 들어가면 안됨
    // 중복되면 @앞에 2, 3 붙이기

    public static void main(String[] args) {
        KTest test = new KTest();
        String s = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String c = "Example";
        System.out.println(test.solution(s,c));

    }

    private final String emailFormat = "<{USERNAME}@{EMAIL}.com>";
    private final String USER_NAME = "{USERNAME}";
    private final String EMAIL = "{EMAIL}";


    public String solution(String S, String C) {
        StringBuffer result = new StringBuffer();
        List<String> emailAddressList = new ArrayList<>();

        String[] nameArray = S.split(",");
        String email = createEmailFormat(C);

        for (String name : nameArray) {
            String employeeEmailEntry = createEmployeeEmailEntry(emailAddressList, name, email);
            emailAddressList.add(employeeEmailEntry);
            result.append(name + " " + employeeEmailEntry + ",");
        }

        return String.valueOf(result.delete(result.length()-1, result.length()));
    }

    private String createEmployeeEmailEntry(List<String> emailAddressList, String name, String email) {
        name = name.trim();
        String employeeEmail =  createEmployeeEmail(name, email);

        if (isDuplicated(emailAddressList, employeeEmail)) {
            employeeEmail = addingSubsequent(emailAddressList, employeeEmail);
        }

        return employeeEmail;
    }


    private String addingSubsequent(List<String> emailAddressList, String employeeEmail) {
        return addingSubsequent(emailAddressList, employeeEmail, 2);
    }

    private String addingSubsequent(List<String> emailAddressList, String employeeEmail, int idx) {
        String subsequentEmployeeEmail = employeeEmail.replaceFirst("@", idx+"@");

        if (isDuplicated(emailAddressList, subsequentEmployeeEmail)) {
            return addingSubsequent(emailAddressList, employeeEmail, idx+1);
        } else {
            return subsequentEmployeeEmail;
        }
    }

    private boolean isDuplicated(List<String> emailAddressList, String employeeEmail) {
        return emailAddressList.contains(employeeEmail);
    }

    private String createEmployeeEmail(String s, String emailFormat) {
        String[] name = s.replaceAll("-", "").split(" ");
        StringBuilder emailName = new StringBuilder();

        appendNameInitial(emailName, name[0]);
        if (name.length > 2) {
            appendNameInitial(emailName, name[1]);
        }
        appendNameInitial(emailName, name[name.length-1], 8);
        return emailFormat.replace(USER_NAME, emailName.toString().toLowerCase());
    }

    private void appendNameInitial(StringBuilder emailName, String name) {
        appendNameInitial(emailName,  name, 1);
    }

    private void appendNameInitial(StringBuilder emailName,  String name,  int idx) {
        emailName.append(name, 0, idx < name.length() ? idx : name.length());
    }

    private String createEmailFormat(String c) {
        return emailFormat.replace(EMAIL, c.toLowerCase());
    }
}
