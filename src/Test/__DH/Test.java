package Test.__DH;

import java.util.ArrayList;
import java.util.List;

public class Test {
    // First.Last@email.com
    // 하이픈 들어가면 안됨
    // 중복되면 @앞에 2, 3 붙이기

    public static void main(String[] args) {
        Test test = new Test();
        String s = "John Doe, Peter Benjamin Parker, Mary Jane Watson-Parker, John Elvis Doe, John Evan Doe, Jane Doe, Peter Brian Parker";
        String c = "Example";
        test.solution(s,c);

    }

    StringBuffer result = new StringBuffer();
    List<String> emailAddressList = new ArrayList<>();

    public String solution(String S, String C) {
        String[] nameArray = S.split(",");
        String emailFormat = createEmailFormat(C);


        for (String s : nameArray) {
            s = s.trim();
            String employeeEmail =  createEmployeeEmail(s, emailFormat);

            if (isDuplicated(employeeEmail)) {
                employeeEmail = addingSubsequent(employeeEmail);
            }

            emailAddressList.add(employeeEmail);
            result.append(s + " " + employeeEmail + ", ");
        }
        result.delete(result.length()-2, result.length());
        return String.valueOf(result);
    }

    private String addingSubsequent(String employeeEmail) {
        return addingSubsequent(employeeEmail, 2);
    }

    private String addingSubsequent(String employeeEmail, int idx) {
        String subsequentEmployeeEmail = employeeEmail.replaceFirst("@", idx+"@");

        if (isDuplicated(subsequentEmployeeEmail)) {
            return addingSubsequent(employeeEmail, idx+1);
        } else {
            return subsequentEmployeeEmail;
        }
    }

    private boolean isDuplicated(String employeeEmail) {
        return emailAddressList.contains(employeeEmail);
    }

    private String createEmployeeEmail(String s, String emailFormat) {
        String[] name = s.split(" ");
        String emailName = (name[0] + "." + name[name.length-1])
                .toLowerCase()
                .replaceAll("-", "");

        return emailFormat.replaceFirst("USER_NAME", emailName);
    }

    private String createEmailFormat(String c) {
        c = c.toLowerCase();
        return "<USER_NAME@"+c+".com>";
    }


}
