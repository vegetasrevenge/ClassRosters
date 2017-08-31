package com.example;

public class ClassHTMLTemplate {

    public static final String header =
            "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Rosters</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "   <!-- Below will be rosters of each 'class' in our array -->\n" +
            "    \n" +
            "    <table>" +
                    "tr>\n" +
                    "            <th>Type</th>\n" +
                    "            <th>ID</th>\n" +
                    "            <th>Grade</th>\n" +
                    "            <th>First Name</th>\n" +
                    "            <th>Last Name</th>\n" +
                    "        </tr>"
            ;

    public static final String personRow =
            " <tr>\n" +
            "            <td>{{type}}</td>\n" +
            "            <td>{{id}}</td>\n" +
            "            <td>{{grade}}</td>\n" +
            "            <td>{{firstName}}</td>\n" +
            "            <td>{{lastName}}</td>\n" +
            "        </tr>";

    public static final String footer =
            " </table>\n" +
            "\n" +
            "</body>\n" +
            "</html>";

}
