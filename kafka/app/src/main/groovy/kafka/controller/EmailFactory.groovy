package kafka.controller

import kafka.model.Candidato

import javax.mail.Address
import javax.mail.Message
import javax.mail.MessagingException
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage
import javax.mail.Authenticator


class EmailFactory {
    GetEmails getEmails = new GetEmails()
    String mandaEmail(String nomeVaga,  String estadoVaga, String cidadeVaga){
        final String sender = "jobcloudmail@gmail.com"
        final String urpass = "udpzzhrxcqqucybf"
        Properties set = new Properties()
        set.put("mail.smtp.starttls.enable", "true")
        set.put("mail.smtp.auth", "true")
        set.put("mail.smtp.host", "smtp.gmail.com")
        set.put("mail.smtp.port", "587")
        set.put("mail.smtp.ssl.trust", "smtp.gmail.com")
        set.put("mail.smtp.ssl.protocols", "TLSv1.2")
        println("Indo pegar os emails")
        ArrayList<String> candidatos = getEmails.getAllEmails()

        Session session = Session.getInstance(set, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, urpass)
            }})

        try {
            for (String emailCandidato : candidatos) {
                MimeMessage email = new MimeMessage(session)
                email.setFrom(new InternetAddress("jobcloudmail@gmail.com"))
                email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailCandidato))
                email.setSubject("Nova vaga na área")

                String text = "<style>\n" +
                        " \tbody, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n" +
                        "\ttable, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n" +
                        "\timg { -ms-interpolation-mode: bicubic; }\n" +
                        "\timg { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\n" +
                        "\ttable { border-collapse: collapse !important; }\n" +
                        "\tbody { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\n" +
                        "\ta[x-apple-data-detectors] { color: inherit !important; text-decoration: none !important; font-size: inherit !important; font-family: inherit !important; font-weight: inherit !important; line-height: inherit !important; }\n" +
                        "\tdiv[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n" +
                        " \t</style>\n" +
                        "\t<body style=\"background-color: #6c33a3; margin: 0 !important; padding: 0 !important;\">\n" +
                        "\t\n" +
                        "\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n" +
                        "\t\t\t<tr>\n" +
                        "\t\t\t\t<td bgcolor=\"#6c33a3\" align=\"center\">\n" +
                        "\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\n" +
                        "\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t<td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\">\n" +
                        "\t\t\t\t\t\t\t\t<div style=\"display: block; font-family: 'Montserrat', sans-serif; color: #ffffff; font-size: 18px;\" border=\"0\">JobCloud</div>\n" +
                        "\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t</table>\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t\t<tr>\n" +
                        "\t\t\t\t<td bgcolor=\"#6c33a3\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
                        "\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\n" +
                        "\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t<td bgcolor=\"#ffffff\" align=\"left\" valign=\"top\" style=\"padding: 30px 30px 20px 30px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Montserrat', sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;\">\n" +
                        "\t\t\t\t\t\t\t\t<h1 style=\"font-size: 32px; font-weight: 400; margin: 0;\"> Tenho novidades pra você</h1>\n" +
                        "\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t</table>\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t\t<tr>\n" +
                        "\t\t\t\t<td bgcolor=\"#6c33a3\" align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\n" +
                        "\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"480\" >\n" +
                        "\t\t\t\t\t\t<tr>\n" +
                        "\t\t\t\t\t\t\t<td bgcolor=\"#ffffff\" align=\"left\">\n" +
                        "\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
                        "                  <tr>\n" +
                        "                    <td colspan=\"2\" style=\"padding-left:30px;padding-right:15px;padding-bottom:10px; font-family: 'Montserrat', sans-serif; font-size: 16px; font-weight: 400; line-height: 25px;\">\n" +
                        "                      <p>A vaga ${nomeVaga} foi aberta agorinha mesmo, dá uma olhada, ela fica em ${cidadeVaga}-${estadoVaga}, vê se não perde essa chance heim! </p>\n" +
                        "                    </td>\n" +
                        "                  </tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t\t\t\t</table>\n" +
                        "\t\t\t\t\t\t\t</td>\n" +
                        "\t\t\t\t\t\t</tr>\n" +
                        "\t\t\t\t\t</table>\n" +
                        "\t\t\t\t</td>\n" +
                        "\t\t\t</tr>\n" +
                        "\t\t</table>\n" +
                        "\t</body>\n" +
                        "<style>\n" +
                        "@import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');\n" +
                        "</style>"
                email.setContent(text, "text/html; charset=utf-8")
                Transport.send(email)
                System.out.println("O email foi enviado")
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e)
        }
    }
}


