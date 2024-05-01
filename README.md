# Invio Shopping Demo Project

Proje Spring Framework kullanilarak tasarlandi . 

Entity , Repository , Service ve Controller katmanlari paket olarak verildi . 

Kullaniciya verilecek response lar icin dto ve util paketleri olusturuldu . Record lar ile response dondurulmaya calisildi.

Tum katmanlar SOLID prensiplerine uygun olacak sekilde tasarlanmaya calisildi . 

Config paketi altindaki WebSocket ve Security Classlari icerisinde projede istenen ayarlamalar yapildi . 

Veri tabani iliskisi icin PostgreSQL kullanildi .  

Asagidaki gorselde tablo baglantilari gorulmektedir . 

User-Role arasinda : ManyToMany relation,

User-Address : OneToMany relation,

Basket(Order)-Product : OneToMany relation olacak sekilde tablo baglantilari yapildi . 

POSTMAN : [<img src="https://run.pstmn.io/button.svg" alt="Run In Postman" style="width: 128px; height: 32px;">](https://null.postman.co/collection/30679926-7581d746-235d-47ab-93e1-efb9bccd96af?source=rip_markdown)

![](/Users/muratsimsek/Desktop/Screenshot 2024-05-01 at 21.29.20.png)