# Selenium Web Automation Test Project

Testinium proje ödevi

* Proje Java programlama dilinde, maven projesi olarak yazıldı
* Selenium, JUnit ve Log4J kütüphaneleri kullanıldı
* Proje OOP (Object Oriented Programming) prensiplerine uygun yazıldı
* Selenium Web otomasyon için Page Object Pattern kullanıldı.


### Selenium Web Otomasyon Test Senaryosu

- beymenTest() @Test Metodu ile aşağıdaki test adımları gerçekleştirilmiştir.
- www.beymen.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir.
- Arama kutucuğuna “şort” kelimesi girilir.(Not = Şort kelimesi excel dosyası
  üzerinden 1 sütun 1 satırdan alınarak yazılmalıdır. )
- Arama kutucuğuna girilen “şort” kelimesi silinir.
- Arama kutucuğuna “gömlek” kelimesi girilir.(Not = Gömlek kelimesi excel dosyası
  üzerinden 2 sütun 1 satırdan alınarak yazılmalıdır. )
- Klavye üzerinden “enter” tuşuna bastırılır
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürünün ürün bilgisi ve tutar bilgisi txt dosyasına yazılır.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.

Web Servis Otomasyon

* Proje Java programlama dilinde, maven projesi olarak yazıldı
- Rest-Asured kütüphaneleri kullanıldı.
- Proje GitHub üzerinden paylaşıldı.
- Proje OOP (Object Oriented Programming) prensiplerine uygun
  yazıldı.


  Api Bilgileri
  Trello key ve token e-posta ile gönderilecektir
  konfigurasyon dosyasına eklenmelidir.
  Github güvenlik nedeniyle engellemiştir.

##### trl_key = api key
##### trl_token = api token

Trello Rest-Api Test Senaryo Adımları
- trelloRestApiTest() @Test metodu ile aşağıdaki test adımları gerçekleştirilmiştir.
- Trello üzerinde bir board oluşturunuz.
- Oluşturduğunuz board’ a iki tane kart oluşturunuz.
- Oluştrduğunuz bu iki karttan random olacak sekilde bir tanesini güncelleyiniz.
- Oluşturduğunuz kartları siliniz.
- Oluşturduğunuz board’ u siliniz.


* İletişim : usinanoglu@gmail.com