＝＝＝本文解决的问题：

－－－－－－－－－－1.首次进入界面，当EditText获取焦点时，软件盘弹出

－－－－－－－－－－2.当activity设置了软键盘自适应，但是它会遮挡所点击EditText下面的控件

＃＃问题1的解决办法：

＊在activity中的setcontentView()方法前加入一下代码：
    
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);    

＃＃问题2的解决办法详解：

－－－－－［详解问题2] (http://blog.csdn.net/qq_23003305/article/details/49305111)

＝＝＝＝需要搞清的问题：
－－－－－当软件盘弹出时，究竟是谁在移动？我们怎么才能控制移动的距离保证我们的控件没有背遮挡

＝＝＝＝认为的最佳的解决方案：
－－－－－我认为最优的解决办法是用ScrollView将外层布局包起来，当软件盘弹出是，让其滚动到底部，显示布局

＝＝＝＝＝＝＝＝＝＝＝＝＝＝软件盘遮挡的解决办法的demo演示：

－－－－－－－－－－－－－

－－－－－－－－－－－－－![aa](http://img1.ph.126.net/NAy6-Jskoi34J1GrTx36QQ==/2624191207891580971.gif);
