我的亲亲小月（莳萝花），想念是会呼吸的痛，她活在我身上所有角落，哼你爱的歌会痛，想你的心会痛，连沉默也痛，我发誓不让你等候，多爱你就会抱你多紧的…………

能重来那就好了  。。 能重来那就好了 。。

生命不过一场幻觉，我只要你在

[你存活在我记忆最原始的荒原，可淡不可忘](https://zhuanlan.zhihu.com/p/25279447)

---2017年2月20日 16:18:35。

# an-aw-zxing 2017年3月22日 11:06:48新zxing

* 项目的主要功能是作为an框架的基类（基础的an-base）的仓库；你可以借助github，jitpack ，bintrary快速集成。

* 框架必须要使用到an-aw-base作为基础。

* 框架来源于本人an-maven-zxing框架（也已停止维护）。

* 框架架构基于MVP，利用an-aw-zxing框架可以快速帮助开发者集成手机二维码的扫码功能。

备注：我想这是我此刻心情不同，唯一一由故事情节而不是任务形象为契机发展而来故事吧。

本项目地址：https://github.com/qydq/an-aw-base

**使用介绍：如下简介或知乎，或个人网易博客。**

>知乎主页：https://zhihu.com/people/qydq

>博客主页：https://bgwan.blog.163.com


**如有使用问题请发送电子邮件。**

>邮件地址： staryumou@163.com  /  qyddai@gmail.com


**特别说明**

	
>创建时间 <------2013年03月22日------->
	
>2013年03月22日;最近修改时间：2017年03月22日。

########
	
**目录**
	
1.前言（包含该项目主要使用方法，功能的简单概述;运行配置,可选）。

2.实现效果（如果没有可以省略，建议包含）。

3.使用方法（代码）。

4.重要知识点（总结，思考）。

5.联系作者。


# [![](https://jitpack.io/v/qydq/an-aw-zxing.svg)](https://jitpack.io/#qydq/an-aw-zxing)       [ ![Download](https://api.bintray.com/packages/qydq/an/an-aw-zxing/images/download.svg) ](https://bintray.com/qydq/an/an-aw-zxing/_latestVersion)

#######

# 1. 前言

**使用Gradle构建时添加以下依赖即可** *（注：也可以使用之前的低稳定版本）*

Step 1：加入依赖之前（在你的根build.gradle文件中增加如下代码。）

```groovy
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

Step 2：加入以后（在你的子build.gradle文件中添加如下依赖关系。）

`compile 'com.github.qydq:an-aw-zxing:1.0'`

或者加入：

`compile 'cn.android.sunst:an-base:1.0'`

使用整套an框架则加入另一个依赖，具体请参考url = https://github.com/qydq/an


**使用建议**

>由于an-aw-zxing使用了an-aw-base，所以项目出现问题建议观看an-aw-base的issue清单。

```groovy
aN框架支持android 4.4+使用，兼容性测试通过，华为Android4.4 ，小米Android5.1，三星Android5.1。
```
##samples apk demo下载参考

[点我下载an-aw-base.apk](https://github.com/qydq/an-aw-base/raw/master/app/app-release.apk)

[下载zhangluyue.apk-文件qydq加密](https://github.com/qydq/an-aw-base/raw/master/app/zhangluyue_jiami.apk)

[点我下载an-aw-zxing.apk](https://github.com/qydq/an-aw-zxing/raw/master/app/app-release.apk)

**Tips**
---
ytips:完善所有功能。
1。支持连续扫描二维码或者条码，
2。支持选择系统的相册对二维码或条码图片进行解析，
3。支持非二维码或条码图片的容错处理，
4。源码中提供了对类似QQ，微信二维码有log的扫描，
5。支持自定义扫描二维码的界面，
6。支持创建二维码，
7。提供了像当前类似流行的单车扫码声音，灯光的CodeUtils工具类，
8。支持控制显示二维码扫描界面右边按钮是否显示的控制。

---------

# 2. 实现效果

实在是没有心情录屏，adb shell screen 上传麻烦，就截两个图给大家观摩下咯，如果要看真实效果在上面点击an-aw-zxing.apk下载即可。

 ![](https://github.com/qydq/an-aw-zxing/blob/master/screen/demo_self.png)

 ![](https://github.com/qydq/an-aw-zxing/blob/master/screen/demo_homepage.png)

---------

# 3. 使用方法（代码）

[MainActivity](https://github.com/qydq/an-aw-zxing/blob/master/app/src/main/java/com/an/an_aw_zxing/MainActivity.java)

[SecondActivity](https://github.com/qydq/an-aw-zxing/blob/master/app/src/main/java/com/an/an_aw_zxing/SecondActivity.java)

---------

# 4. 重要知识点。

		
---------

# 5. 联系作者。

Athor IP：sunshuntao（qydq）（莳萝花）。

Email：qyddai@gmail.com。

欢迎大家使用aN快速开发框架。
If it doesn't work, please send me a email, qyddai@gmail.com
An框架可能存在一些缺陷，有问题欢迎大家反馈，收到邮件我会第一次时间回复处理。

Or

Import the library, then add it to your /settings.gradle and /app/build.gradle, if you don't know how to do it, you can read my blog for help.
http://drakeet.me/android-studio


# Thanks

android-zxingLibrary

[google cod](http://repo1.maven.org/maven2/com/)

#打赏

觉得本框架对你有帮助，不妨打赏赞助我一下，让我有动力走的更远。

 <img src="https://github.com/qydq/an-aw-base/blob/master/app/src/main/res/mipmap-xxhdpi/qydq_an_alipay.png" width=280 />

 
 好吧，别把我想的惟利是图了，我根本不缺钱，只是成就感罢了。
 
 其实去他妈的成就感，去他妈物质，我一生浪费过太多的时间，却尤其在意跟月月在一起的分分miaomiao ，可是……怎么会这样啊。fuck fuck the world .i'm sorry to everyone./
 
 你这么优秀，为何为何为何 到底是为什么？就不能多……。
 
 
---------

		
## 权限相关。an-aw-zxing /AndroidManifest.xml	(由于二维码需要获取手机相机扫描的权限，其它网络权限)

	<uses-permission android:name="android.permission.FLASHLIGHT" />
    <uses-permission android:name="android.permission.VIBRATE" />
    <uses-permission android:name="android.permission.CAMERA" />

    <uses-feature android:name="android.hardware.camera" />
    <uses-feature android:name="android.hardware.camera.autofocus" />

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />
		
		

## 2017/03/23  17：48

>能重来就好了。

最新编译版本

`compile 'com.github.qydq:an-aw-zxing:1.0'`

更新说明：
```groovy
0。完成了README.mk说明，全部重新补充。
1。支持连续扫描二维码或者条码，
2。支持选择系统的相册对二维码或条码图片进行解析，
3。支持非二维码或条码图片的容错处理，
4。源码中提供了对类似QQ，微信二维码有log的扫描，
5。支持自定义扫描二维码的界面，
6。支持创建二维码，
7。提供了像当前类似流行的单车扫码声音，灯光的CodeUtils工具类，
8。支持控制显示二维码扫描界面右边按钮是否显示的控制。
```

准备发布1.0的版本，

后期该zxing可能有小幅度的调整，欢迎大家star  ,*本着开源的精神，转载标明出处即可。*

如果有任何使用问题，请提issue ,或发送emai To me l :qyddai@gmail.com，以前的staryumou@163.com邮箱不再使用 ,因为到处都是伤。

晴雨晴 2017年3月23日 11:36:59

