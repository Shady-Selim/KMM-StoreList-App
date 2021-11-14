package com.shady.kmm.dummyData

import com.shady.kmm.entity.BannersList

abstract class BannerData {
    companion object {
        fun getDummyBanners(): List<BannersList> {
            var newArray = mutableListOf<BannersList>()
            var banner = BannersList(
                id= 117,
                title= "هلا والله بشريكنا الغالي ! 🚀",
                description= "ابشر بـ خصم ٥٪ يوصل إلى ٥٠ ريال على اول طلب وعليها توصيل مجاني. استخدم كود الخصم: Hala",
                button_text= "اطلب الان ⬅️",
                expiry_status= false,
                created_at= "2020-06-09",
                start_date= "09/06/2020",
                expiry_date= "31/12/2020",
                image= "https://devcdn.sary.co/banners/2020/06/09/June_Banners-02.png",
                priority= 5000,
                photo= "https://devcdn.sary.co/June_Banners-04.png",
                link= "sary://sary.com/discount?promocode=hala",
                level= "global",
                is_available= true,
                branch= 5
            )
            newArray.add(banner)

            banner = BannersList(
                id= 160,
                title= "هلا والله بشريكنا الغالي ! 🚀",
                description= "ابشر بـ خصم ٥٪ يوصل إلى ٥٠ ريال على اول طلب وعليها توصيل مجاني. استخدم كود الخصم: Hala",
                button_text= "اطلب الان ⬅️",
                expiry_status= false,
                created_at= "2020-09-10",
                start_date= "10/09/2020",
                expiry_date= "31/12/2020",
                image= "https://devcdn.sary.co/banners/2020/09/11/June_Banners-02.png",
                priority= 500,
                photo= "https://devcdn.sary.co/June_Banners-04_g3O64Sc_KCjyWHn.png",
                link= "sary://sary.com/discount?promocode=hala",
                level= "global",
                is_available= true,
                branch= 5
            )
            newArray.add(banner)

            banner = BannersList(
                id= 119,
                title= "توريد بقالتك خله علينا! 📚",
                description= "الحين صار يمديك تجهز كل الاحتياجات المكتبية لبقالتك و بأوفر الأسعار.",
                button_text= "سرينا لقسم المكتبة!",
                expiry_status= false,
                created_at= "2020-06-15",
                start_date= "15/06/2020",
                expiry_date= "22/12/2020",
                image= "https://devcdn.sary.co/banners/2020/06/16/banA.png",
                priority= 200,
                photo= "https://devcdn.sary.co/phAA.png",
                link= "sary://sary.com/group?id=248",
                level= "global",
                is_available= true,
                branch= 5
            )
            newArray.add(banner)
            return newArray
        }
    }
}