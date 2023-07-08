# StockMarket-SpringBoot

Bu,  StockMarket-SpringBoot adlı basit bir stok takip uygulamasıdır.

## Özellikler
- Kullanıcılar sisteme kayıt olabilir ve kendi portfoliolarını oluşturabilir
- Kendi portfoliolarını paylaşıp kar zarar durumunu herkeze gösterbilir
- Giriş sayfasında en çok kazandıran portfolioların listesi bulunur(detaylarıyla birlikte) 
- Portfolio oluşturmuş kullanıcı portfoliosuna coin ekleyebilir veya silebilir
- Kullanıcılar birbirlerini takip edebilir böylece istemediği kişilerin portfoliolarını görmeyebilir
- Login kısmında springsecurity ve jwttoken kullanılmıştır 

## Enpointler

- (GET)  /coin/all -> Tüm coinleri listeler
- (GET)  /coin/{symbol} -> isme göre coini listeler
- (Post) /user/add -> kullanıcı sisteme ekler
- (Get) /user/all -> Tüm kullanıcıları listeler
- (Post) /user/authenticate -> kullanıcıları login yapar
- (Get) /user/name/{name} -> isme göre kullanıcıyı listeler
- (Get) /user/{id} ->İd ye göre kullanıcıları listeler
- (Post) /portfolio/add/{id} -> kullanıcıların portfoliosuna coini ekler
- (Post) /potfolio/create -> kullanıcıya yeni portfolio oluşturur
- (Delete) portfolio/delete/coin/{porfid} -> portfoliodan coin siler
- (GEt)  /portfolio/getAll -> Tüm portfolioları listeler
- (Delete) /portfolio/{portfıd}/delete -> idye göre portfolioyun siler
- proje geliştirme aşamasında olduğu için daha birçok endpoint eklenecektir

 ### Kullanılan teknolojiler

- Mysql,Hibernate,JwtToken,SpringSecurtiy,Jpa,Lombok,SpringWeb

### Kurulum

1. Bu repository'i yerel bilgisayarınıza klonlayın:
2. gerekli bağımlıkları kurun ve çalıştırın

