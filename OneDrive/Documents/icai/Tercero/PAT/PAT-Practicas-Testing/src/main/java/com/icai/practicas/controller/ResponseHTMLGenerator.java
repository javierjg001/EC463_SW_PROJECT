package com.icai.practicas.controller;

public class ResponseHTMLGenerator {

    public static String message1 =
            """
            <!doctype>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Response 1</title>
                </head>
                <body>
                    <h1>Muchas gracias por enviar los datos</h1>
                    <a href="/">Volver</a>
                </body>
            </html>
            """;

    public static String message2 =
            """
            <!doctype>
            <html>
                <head>
                    <meta charset="UTF-8">
                    <title>Response 1</title>
                </head>
                <body>
                    <h1>Hemos tenido un problema con su solicitud.</h1>
                    <p>Revise los datos introducidos</p>
                    <a href="javascript:history.back()">Volver</a>
                </body>
            </html>
            """;

}
