�ҵ�����С�£�ݪ�ܻ���������뿪�ҡ�

��������һ���þ�����ֻҪ����

���뿪���ÿ���Ѿ�һ������û��ά���ˣ�������ʰ���䣬ֻΪ��� ��. ��

д����¶�µ�һƪ���£����ֳ�¼��

[�������Ҽ�����ԭʼ�Ļ�ԭ���ɵ�������](https://zhuanlan.zhihu.com/p/25279447)

---2017��2��20�� 16:18:35��

# an-aw-zxing 2017��3��22�� 11:06:48��zxing

* ��Ŀ����Ҫ��������Ϊan��ܵĻ��ࣨ������an-base���Ĳֿ⣻����Խ���github��jitpack ��bintrary���ټ��ɡ�

* ��ܱ���Ҫʹ�õ�an-aw-base��Ϊ������

* �����Դ�ڱ���an-maven-zxing��ܣ���ֹͣά������

* ��ܼܹ�����MVP������an-aw-zxing��ܿ��Կ��ٰ��������߼����ֻ���ά���ɨ�빦�ܡ�

��ע�����������Ҵ˿����鲻ͬ��Ψһһ�ɹ�����ڶ�������������Ϊ������չ�������°ɡ�

����Ŀ��ַ��https://github.com/qydq/an-aw-base

**ʹ�ý��ܣ����¼���֪������������ײ��͡�**

>֪����ҳ��https://zhihu.com/people/qydq

>������ҳ��https://bgwan.blog.163.com


**����ʹ�������뷢�͵����ʼ���**

>�ʼ���ַ�� staryumou@163.com  /  qyddai@gmail.com


**�ر�˵��**

	
>����ʱ�� <------2013��03��22��------->
	
>2013��03��22��;����޸�ʱ�䣺2017��03��22�ա�

########
	
**Ŀ¼**
	
1.ǰ�ԣ���������Ŀ��Ҫʹ�÷��������ܵļ򵥸���;��������,��ѡ����

2.ʵ��Ч�������û�п���ʡ�ԣ������������

3.ʹ�÷��������룩��

4.��Ҫ֪ʶ�㣨�ܽᣬ˼������

5.��ϵ���ߡ�


# [![](https://jitpack.io/v/qydq/an-aw-base.svg)](https://jitpack.io/#qydq/an-aw-base)       [ ![Download](https://api.bintray.com/packages/qydq/an/an-aw-base/images/download.svg?version=an-aw-base%3A2.0.1) ](https://bintray.com/qydq/an/an-aw-base/an-aw-base%3A2.0.1/link)

#######

# 1. ǰ��

**ʹ��Gradle����ʱ���������������** *��ע��Ҳ����ʹ��֮ǰ�ĵ��ȶ��汾��*

Step 1����������֮ǰ������ĸ�build.gradle�ļ����������´��롣��

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Step 2�������Ժ��������build.gradle�ļ����������������ϵ����

`compile 'com.github.qydq:an-aw-base:0.2.3'`

���߼��룺

`compile 'cn.android.sunst:an-base:2.0.1'`

ʹ������an����������һ��������������ο�url = https://github.com/qydq/an


**ʹ�ý���**

>����an-aw-zxingʹ����an-aw-base��������Ŀ�������⽨��ۿ�an-aw-base��issue�嵥��

```groovy
aN���֧��android 4.4+ʹ�ã������Բ���ͨ������ΪAndroid4.4 ��С��Android5.1������Android5.1��
```
##samples apk demo���زο�

[��������an-aw-base.apk](https://github.com/qydq/an-aw-base/raw/master/app/app-release.apk)

[����zhangluyue.apk-�ļ��Ѽ���](https://github.com/qydq/an-aw-base/raw/master/app/zhangluyue_jiami.apk)

**Tips**
---


---------

# 2. ʵ��Ч��



---------

# 3. ʹ�÷��������룩



---------

# 4. ��Ҫ֪ʶ�㡣

		
---------

# 5. ��ϵ���ߡ�

Athor IP��sunshuntao��qydq����ݪ�ܻ�����

Email��qyddai@gmail.com��

��ӭ���ʹ��aN���ٿ�����ܡ�
If it doesn't work, please send me a email, qyddai@gmail.com
An��ܿ��ܴ���һЩȱ�ݣ������⻶ӭ��ҷ������յ��ʼ��һ��һ��ʱ��ظ�����

Or

Import the library, then add it to your /settings.gradle and /app/build.gradle, if you don't know how to do it, you can read my blog for help.
http://drakeet.me/android-studio


# Thanks



#����

���ñ���ܶ����а�������������������һ�£������ж����ߵĸ�Զ��

 <img src="https://github.com/qydq/an-aw-base/blob/master/app/src/main/res/mipmap-xxhdpi/qydq_an_alipay.png" width=280 />

---------

		
## Ȩ����ء�an-mave-base /AndroidManifest.xml	

    <!-- �������Ȩ�� -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <!-- WIFI״̬�������Ȩ��-->
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <!-- ��SDCardд������Ȩ�� -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- ��SDCard��ȡ����Ȩ�� -->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <!-- ��SDCard �Ĺ���Ȩ�� -->
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
		
		

## 2017/03/22  17��48

>�������ͺ��ˡ�

���±���汾

`compile 'com.github.qydq:an-aw-base:0.2.5'`

����˵����


