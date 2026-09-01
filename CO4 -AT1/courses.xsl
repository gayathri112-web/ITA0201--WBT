<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>High Enrollment Courses</title>
                <meta charset="UTF-8"/>
                <style>
                    body { font-family: Arial, sans-serif; background:#f4f7fb; margin:0; padding:40px; }
                    .container { max-width:1000px; margin:auto; background:white; padding:30px; border-radius:16px; box-shadow:0 8px 25px rgba(0,0,0,.08); }
                    h1 { margin-top:0; }
                    table { width:100%; border-collapse:collapse; margin-top:20px; }
                    th, td { padding:13px; border-bottom:1px solid #ddd; text-align:left; }
                    th { background:#243b53; color:white; }
                    tr:hover { background:#f1f5f9; }
                    .badge { padding:5px 9px; border-radius:12px; background:#e2e8f0; }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>High Enrollment Courses</h1>
                    <p>Courses with more than 40 students, sorted by enrollment in descending order.</p>
                    <table>
                        <tr>
                            <th>Course Code</th>
                            <th>Course Name</th>
                            <th>Faculty</th>
                            <th>Students</th>
                            <th>Credits</th>
                            <th>Type</th>
                        </tr>
                        <xsl:for-each select="/courses/course[students &gt; 40]">
                            <xsl:sort select="students" data-type="number" order="descending"/>
                            <tr>
                                <td><xsl:value-of select="code"/></td>
                                <td><xsl:value-of select="name"/></td>
                                <td><xsl:value-of select="faculty"/></td>
                                <td><xsl:value-of select="students"/></td>
                                <td><xsl:value-of select="credits"/></td>
                                <td><span class="badge"><xsl:value-of select="type"/></span></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
