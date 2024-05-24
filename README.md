<h1>Втора лабораториска вежба по Софтверско инженерство</h1>
<h2>Марко Тасевски</h2>
<h3>Control Flow Graph</h3>

![lab2final](https://github.com/markotasevski1/SI_2024_lab2_191230/blob/main/SILAB02.png)


<h3>Цикломатска комплексност</h3>
<p>Цикломатска комплексност: M=E-N+2p = 8</p>

<h3>Тест случаи според критериумот Every Branch, користам 4 случаи.</h3>
<p>- Случај allItems = null.<br></p>
<p>- Случај кога getBarcode!=null или должина на name =0 </p>
<p>- Случај кога barcode e различно од null</p>
<p>- Случај кога sum <= payment </p>

<h3>Тест случаи според критериумот Multiple Condition</h3>
<h4>Имаме -  2 </h4>
<p>- item.getName() == null || item.getName().length() == 0</p>
<p>- item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'</p>

<h3>Објаснување на напишаните unit tests</h3>
<p>-testAllItemsNull test koga all items se null<br></p>
<p>-getBarcode!=null или должина на name =0</p>
<p>-samo koga branchCode e razlicno od null</p>
<p>- Случај кога sum <= payment</p>
<h4>Tests za Every Branch:</h4>
<p>-test za name e null ili name e so dolzina 0<br></p>
<p>-test koga item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'</p>
