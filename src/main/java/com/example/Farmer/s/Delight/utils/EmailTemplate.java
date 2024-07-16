package com.example.Farmer.s.Delight.utils;

public class EmailTemplate {
    public static String createWelcomeMessageFor(String name){

        return """
                    <!DOCTYPE html>
                    <html lang="en">
                    <head>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                        <title>Welcome to DakAgro</title>
                        <style>
                           body {
                               font-family: Arial, sans-serif;
                               background-color: #f4f4f4;
                               padding: 10px;
                               display:flex;
                               flex-direction: column;
                               justify-content: center;
                               align-items: center;
                           }
                            .container {
                                max-width: 600px;
                                margin: 1 auto;
                                background-color: #ffffff;
                                padding: 20px;
                                border-radius: 8px;
                                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                            }
                            .header {
                                text-align: center;
                                padding: 10px 0;
                            }
                            .header img {
                                max-width: 400px;
                            }
                            .content {
                                padding: 20px;
                            }
                            .content h1 {
                                color: #333333;
                            }
                            .content p {
                                color: #666666;
                                line-height: 1.5;
                            }
                            a {
                                text-decoration: none;
                            }
                            .button {
                                display: inline-block;
                                padding: 10px 20px;
                                margin-top: 20px;
                                background-color: #28a745;
                                color: #ffffff;
                                text-decoration: none;
                                border-radius: 5px;
                            }
                            .footer {
                                text-align: center;
                                padding: 20px;
                                font-size: 12px;
                                color: #999999;
                            }
                        </style>
                    </head>
                    <body>
                        <div class="container">
              
                            <div class="content">
                                <h1>Welcome to DakAgro</h1>
                                <p>Dear Customer</p>
                                <p>Thank you for signing up on our platform. We are thrilled to have you on board.
                                Our platform offers a range of features designed to help you get the most out of your experience.</p>
                                <p>If you have any questions or need assistance, feel free to contact our support team.</p>
                                <p>Best regards,<br>The DakAgro Team</p>
                            </div>
                            <div class="footer">
                                <p>&copy; 2024 DakAgro. All rights reserved.</p>
                            </div>
                        </div>
                    </body>
                    </html>
                   """;
    }
}
