#参考instant run 实现热修复的一点尝试
***这仅仅是一点尝试***

***代码全部来自instant run***

##TODO
1. 尝试研究gradle创插件，最终目标是能向instant run功能一样，自动注入必须代码。
2. 别光尝试了，写个自己自己玩的。

##说明:
1. app-debug.apk.bk，去掉点.bk就是apk了，点击test按钮，会输出hello not patched
2. patch.dex是patch文件，push到/data/data/com.echo.hotpatch/files/patch目录之后，点击patch，然后点test就会输出patched了。

##参考
[instant run源码](https://android.googlesource.com/platform/tools/base/+/studio-master-dev/instant-run/)
