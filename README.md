我的亲亲小月（莳萝花），你别离开我。

生命不过一场幻觉，我只要你在

她离开。该框架已经一个多月没有维护了，而今重拾记忆，只为情故 。. 。

写给张露月的一篇文章（已手抄录）

[你存活在我记忆最原始的荒原，可淡不可忘](https://zhuanlan.zhihu.com/p/25279447)

---2017年2月20日 16:18:35。

# an-aw-zxing 2017年3月22日 11:06:48新zxing

* 项目的主要功能是作为an框架的基类（基础的an-base）的仓库；你可以借助github，jitpack ，bintrary快速集成。

* 框架必须要使用到an-aw-base作为基础。

* 框架来源于本人an-maven-zxing框架（已停止维护）。

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


# [![](https://jitpack.io/v/qydq/an-aw-base.svg)](https://jitpack.io/#qydq/an-aw-base)       [ ![Download](https://api.bintray.com/packages/qydq/an/an-aw-base/images/download.svg?version=an-aw-base%3A2.0.1) ](https://bintray.com/qydq/an/an-aw-base/an-aw-base%3A2.0.1/link)

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

`compile 'com.github.qydq:an-aw-base:0.2.3'`

或者加入：

`compile 'cn.android.sunst:an-base:2.0.1'`

使用整套an框架则加入另一个依赖，具体请参考url = https://github.com/qydq/an


**使用建议**

>由于an-aw-zxing使用了an-aw-base，所以项目出现问题建议观看an-aw-base的issue清单。

```groovy
aN框架支持android 4.4+使用，兼容性测试通过，华为Android4.4 ，小米Android5.1，三星Android5.1。
```
##samples apk demo下载参考

[点我下载an-aw-base.apk](https://github.com/qydq/an-aw-base/raw/master/app/app-release.apk)

[下载zhangluyue.apk-文件已加密](https://github.com/qydq/an-aw-base/raw/master/app/zhangluyue_jiami.apk)

**Tips**
---


---------

# 2. 实现效果



---------

# 3. 使用方法（代码）



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



#打赏

觉得本框架对你有帮助，不妨打赏赞助我一下，让我有动力走的更远。

 <img src="https://github.com/qydq/an-aw-base/blob/master/app/src/main/res/mipmap-xxhdpi/qydq_an_alipay.png" width=280 />

---------

		
## 权限相关。an-mave-base /AndroidManifest.xml	

    <!-- 网络相关权限 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <!-- WIFI状态监听相关权限-->
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <!-- 往SDCard写入数据权限 -->
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <!-- 往SDCard读取数据权限 -->
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <!-- 在SDCard 的挂载权限 -->
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS" />
		
		

## 2017/03/22  17：48

>能重来就好了。

最新编译版本

`compile 'com.github.qydq:an-aw-base:0.2.5'`

更新说明：


