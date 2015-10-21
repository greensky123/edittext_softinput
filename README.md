＝＝＝本文解决的问题：

－－－－－－－－－－1.首次进入界面，当EditText获取焦点时，软件盘弹出

－－－－－－－－－－2.当activity设置了软键盘自适应，但是它会遮挡所点击EditText下面的控件

＃＃问题1的解决办法：

＊在activity中的setcontentView()方法前加入一下代码：
    
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);    

＃＃问题2的解决办法详解：

－－－－－［this is a link] (http://blog.csdn.net/qq_23003305/article/details/49304525)

＝＝＝＝需要搞清的问题：


＝＝＝＝认为的最佳的解决方案：


＝＝＝＝＝＝＝＝＝＝＝＝＝＝软件盘遮挡的解决办法的demo演示：

－－－－－－－－－－－－－

－－－－－－－－－－－－－![aa](http://img1.ph.126.net/NAy6-Jskoi34J1GrTx36QQ==/2624191207891580971.gif);
