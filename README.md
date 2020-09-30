Bu proje spring kullanılarak yapılmış olan bir kitap tanıtım sitesidir.

Kurulumu için gerekenler:


<ul>
  <li>Java jdk 11</li>
  <li>Docker</li>
  <li>İnternet Bağlantısı</li>
  <li><a href="https://drive.google.com/file/d/1W_mo_J4NVgT0JIMPtGc7nh5-WM8QnEdX/view?usp=sharing">Docker-compose ve veritabanı</a></li>
  <li>Bilgisayarınızda 3306 ve 8080 portlarının boş olması gerekiyor</li>
</ul>

<h4>1. Adım</h4>
<p>İndirdiğiniz zip dosyasını arşivden çıkarın.</p>
<br>

<h4>2. Adım</h4>
<p>ozgurLib klasörünün içinde şu komutu çalıştırın: </p> docker-compose.exe -f stack.yaml up
<br>

<h4>3. Adım</h4>
Projeyi indirin

Projenin bulunduğu dizinde <br>
Windows kullanıcıları için: mvnw.cmd package <br>
Gnu/Linux veya mac için: ./mvnw package

komudunu çalıştırın.

<h4>4. Adım</h4>

target klasörünün içinde OzgurLib-0.0.1-SNAPSHOT.jar doyasını

java -jar OzgurLib-0.0.1-SNAPSHOT.jar komuduyla çalıştırın.
