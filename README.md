�ҵ�����С�£�ݪ�ܻ����������ǻ������ʹ�����������������н��䣬���㰮�ĸ��ʹ��������Ļ�ʹ������ĬҲʹ���ҷ��Ĳ�����Ⱥ򣬶మ��ͻᱧ�����ġ�������

�������Ǿͺ���  ���� �������Ǿͺ��� ����

��������һ���þ�����ֻҪ����

[�������Ҽ�����ԭʼ�Ļ�ԭ���ɵ�������](https://zhuanlan.zhihu.com/p/25279447)

---2017��2��20�� 16:18:35��

# an-aw-zxing 2017��3��22�� 11:06:48��zxing

* ��Ŀ����Ҫ��������Ϊan��ܵĻ��ࣨ������an-base���Ĳֿ⣻����Խ���github��jitpack ��bintrary���ټ��ɡ�

* ��ܱ���Ҫʹ�õ�an-aw-base��Ϊ������

* �����Դ�ڱ���an-maven-zxing��ܣ�Ҳ��ֹͣά������

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


# [![](https://jitpack.io/v/qydq/an-aw-zxing.svg)](https://jitpack.io/#qydq/an-aw-zxing)       [ ![Download](https://api.bintray.com/packages/qydq/an/an-aw-zxing/images/download.svg) ](https://bintray.com/qydq/an/an-aw-zxing/_latestVersion)

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

`compile 'com.github.qydq:an-aw-zxing:1.0'`

���߼��룺

`compile 'cn.android.sunst:an-base:1.0'`

ʹ������an����������һ��������������ο�url = https://github.com/qydq/an


**ʹ�ý���**

>����an-aw-zxingʹ����an-aw-base��������Ŀ�������⽨��ۿ�an-aw-base��issue�嵥��

```groovy
aN���֧��android 4.4+ʹ�ã������Բ���ͨ������ΪAndroid4.4 ��С��Android5.1������Android5.1��
```
##samples apk demo���زο�

[��������an-aw-base.apk](https://github.com/qydq/an-aw-base/raw/master/app/app-release.apk)

[����zhangluyue.apk-�ļ�qydq����](https://github.com/qydq/an-aw-base/raw/master/app/zhangluyue_jiami.apk)

[��������an-aw-zxing.apk](https://github.com/qydq/an-aw-zxing/raw/master/app/app-release.apk)

**Tips**
---
ytips:�������й��ܡ�
1��֧������ɨ���ά��������룬
2��֧��ѡ��ϵͳ�����Զ�ά�������ͼƬ���н�����
3��֧�ַǶ�ά�������ͼƬ���ݴ���
4��Դ�����ṩ�˶�����QQ��΢�Ŷ�ά����log��ɨ�裬
5��֧���Զ���ɨ���ά��Ľ��棬
6��֧�ִ�����ά�룬
7���ṩ����ǰ�������еĵ���ɨ���������ƹ��CodeUtils�����࣬
8��֧�ֿ�����ʾ��ά��ɨ������ұ߰�ť�Ƿ���ʾ�Ŀ��ơ�

---------

# 2. ʵ��Ч��

ʵ����û������¼����adb shell screen �ϴ��鷳���ͽ�����ͼ����ҹ�Ħ�¿������Ҫ����ʵЧ����������an-aw-zxing.apk���ؼ��ɡ�

 ![](https://github.com/qydq/an-aw-zxing/blob/master/screen/demo_self.png)

 ![](https://github.com/qydq/an-aw-zxing/blob/master/screen/demo_homepage.png)

---------

# 3. ʹ�÷��������룩

[MainActivity](https://github.com/qydq/an-aw-zxing/blob/master/app/src/main/java/com/an/an_aw_zxing/MainActivity.java)

[SecondActivity](https://github.com/qydq/an-aw-zxing/blob/master/app/src/main/java/com/an/an_aw_zxing/SecondActivity.java)

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

android-zxingLibrary

[google cod](http://repo1.maven.org/maven2/com/)

#����

���ñ���ܶ����а�������������������һ�£������ж����ߵĸ�Զ��

 <img src="https://github.com/qydq/an-aw-base/blob/master/app/src/main/res/mipmap-xxhdpi/qydq_an_alipay.png" width=280 />

 
 �ðɣ���������Ω����ͼ�ˣ��Ҹ�����ȱǮ��ֻ�ǳɾ͸а��ˡ�
 
 ��ʵȥ����ĳɾ͸У�ȥ�������ʣ���һ���˷ѹ�̫���ʱ�䣬ȴ���������������һ��ķַ�miaomiao �����ǡ�����ô����������fuck fuck the world .i'm sorry to everyone./
 
 ����ô���㣬Ϊ��Ϊ��Ϊ�� ������Ϊʲô���Ͳ��ܶ࡭����
 
 
---------

		
## Ȩ����ء�an-aw-zxing /AndroidManifest.xml	(���ڶ�ά����Ҫ��ȡ�ֻ����ɨ���Ȩ�ޣ���������Ȩ��)

	<uses-permission android:name="android.permission.FLASHLIGHT" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.CAMERA" />

    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
		
		

## 2017/03/23  17��48

>�������ͺ��ˡ�

���±���汾

`compile 'com.github.qydq:an-aw-zxing:1.0'`

����˵����
```groovy
0�������README.mk˵����ȫ�����²��䡣
1��֧������ɨ���ά��������룬
2��֧��ѡ��ϵͳ�����Զ�ά�������ͼƬ���н�����
3��֧�ַǶ�ά�������ͼƬ���ݴ���
4��Դ�����ṩ�˶�����QQ��΢�Ŷ�ά����log��ɨ�裬
5��֧���Զ���ɨ���ά��Ľ��棬
6��֧�ִ�����ά�룬
7���ṩ����ǰ�������еĵ���ɨ���������ƹ��CodeUtils�����࣬
8��֧�ֿ�����ʾ��ά��ɨ������ұ߰�ť�Ƿ���ʾ�Ŀ��ơ�
```

׼������1.0�İ汾��

���ڸ�zxing������С���ȵĵ�������ӭ���star  ,*���ſ�Դ�ľ���ת�ر����������ɡ�*

������κ�ʹ�����⣬����issue ,����emai To me l :qyddai@gmail.com����ǰ��staryumou@163.com���䲻��ʹ�� ,��Ϊ���������ˡ�

������ 2017��3��23�� 11:36:59

