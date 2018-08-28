/*
SQLyog v10.2 
MySQL - 5.6.24 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `t_blog` */

DROP TABLE IF EXISTS `t_blog`;

CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longtext,
  `create_time` datetime DEFAULT NULL,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  KEY `FK8ky5rrsxh01nkhctmo7d48p82` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_blog` */

insert  into `t_blog`(`id`,`appreciation`,`commentabled`,`content`,`create_time`,`first_picture`,`flag`,`published`,`recommend`,`share_statement`,`title`,`update_time`,`views`,`type_id`,`user_id`) values (1,'','','[IntelliJ IDEA（三） ：常用快捷键](https://www.cnblogs.com/jajian/p/8012603.html)\r\n========================================================================\r\n\r\n说IDEA对新手来说难，可能其中一个原因就是快捷键组合多而且复杂但是它也很全，基本所有功能都可以通过快捷键来完成，可以这么说，如果你掌握了所有IDEA的快捷键使用，那么你完全可以丢掉鼠标，而且不影响开发效率。\r\n\r\n一、Ctrl 快捷键\r\n----------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  + F 在当前文件进行文本查找  （必备）\r\n2.  Ctrl  + R 在当前文件进行文本替换  （必备）\r\n3.  Ctrl  + Z 撤销  （必备）\r\n4.  Ctrl  + Y 删除光标所在行  或  删除选中的行  （必备）\r\n5.  Ctrl  + X 剪切光标所在行  或  剪切选择内容\r\n6.  Ctrl  + C 复制光标所在行  或  复制选择内容\r\n7.  Ctrl  + D 复制光标所在行  或  复制选择内容，并把复制内容插入光标位置下面  （必备）\r\n8.  Ctrl  + W 递进式选择代码块。可选中光标所在的单词或段落，连续按会在原有选中的基础上再扩展选中范围（必备）\r\n9.  Ctrl  + E 显示最近打开的文件记录列表  （必备）\r\n10.  Ctrl  + N 根据输入的  名/类名  查找类文件  （必备）\r\n11.  Ctrl  + G 在当前文件跳转到指定行处\r\n12.  Ctrl  + J 插入自定义动态代码模板  （必备）\r\n13.  Ctrl  + P 方法参数提示显示  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  + Q 光标所在的变量  /  类名  /  方法名等上面（也可以在提示补充的时候按），显示文档内容\r\n2.  Ctrl  + U 前往当前光标所在的方法的父类的方法  /  接口定义  （必备）\r\n3.  Ctrl  + B 进入光标所在的方法/变量的接口或是定义处，等效于  Ctrl  +  左键单击  （必备）\r\n4.  Ctrl  + K 版本控制提交项目，需要此项目有加入到版本控制才可用\r\n5.  Ctrl  + T 版本控制更新项目，需要此项目有加入到版本控制才可用\r\n6.  Ctrl  + H 显示当前类的层次结构\r\n7.  Ctrl  + O 选择可重写的方法\r\n8.  Ctrl  + I 选择可继承的方法\r\n9.  Ctrl  +  +  展开代码\r\n10.  Ctrl  +  -  折叠代码\r\n11.  Ctrl  +  /  释光标所在行代码，会根据当前不同文件类型使用不同的注释符号  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  \\[  移动光标到当前所在代码的花括号开始位置\r\n2.  Ctrl  +  \\]  移动光标到当前所在代码的花括号结束位置\r\n3.  Ctrl  + F1 在光标所在的错误代码处显示错误信息  （必备）\r\n4.  Ctrl  + F3 调转到所选中的词的下一个引用位置  （必备）\r\n5.  Ctrl  + F4 关闭当前编辑文件\r\n6.  Ctrl  + F8 在  Debug  模式下，设置光标当前行为断点，如果当前已经是断点则去掉断点\r\n7.  Ctrl  + F9 执行  Make  Project  操作\r\n8.  Ctrl  + F11 选中文件  /  文件夹，使用助记符设定  /  取消书签  （必备）\r\n9.  Ctrl  + F12 弹出当前文件结构层，可以在弹出的层上直接输入，进行筛选\r\n10.  Ctrl  +  Tab  编辑窗口切换，如果在切换的过程又加按上  delete，则是关闭对应选中的窗口\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  End  跳到文件尾\r\n2.  Ctrl  +  Home  跳到文件头\r\n3.  Ctrl  +  Space  基础代码补全，默认在  Windows  系统上被输入法占用，需要进行修改，建议修改为  Ctrl  +逗号  （必备）\r\n4.  Ctrl  +  Delete  删除光标后面的单词或是中文句  （必备）\r\n5.  Ctrl  +BackSpace  删除光标前面的单词或是中文句  （必备）\r\n6.  Ctrl  +1,2,3...9  定位到对应数值的书签位置  （必备）\r\n7.  Ctrl  +  左键单击  在打开的文件标题上，弹出该文件路径  （必备）\r\n8.  Ctrl  +  光标定位按  Ctrl  不要松开，会显示光标所在的类信息摘要\r\n9.  Ctrl  +  左方向键  光标跳转到当前单词  /  中文句的左侧开头位置  （必备）\r\n10.  Ctrl  +  右方向键  光标跳转到当前单词  /  中文句的右侧开头位置  （必备）\r\n11.  Ctrl  +  前方向键  等效于鼠标滚轮向前效果  （必备）\r\n12.  Ctrl  +  后方向键  等效于鼠标滚轮向后效果  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n二、Alt 快捷键\r\n---------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Alt  +  `   显示版本控制常用操作菜单弹出层 （必备）\r\n2.  Alt + Q   弹出一个提示，显示当前类的声明 / 上下文信息\r\n3.  Alt + F1  显示当前文件选择目标弹出层，弹出层中有很多目标可以进行选择 （必备）\r\n4.  Alt + F2  对于前面页面，显示各类浏览器打开目标选择弹出层\r\n5.  Alt + F3  选中文本，逐个往下查找相同文本，并高亮显示\r\n6.  Alt + F7  查找光标所在的方法 / 变量 / 类被调用的地方\r\n7.  Alt + F8  在 Debug 的状态下，选中对象，弹出可输入计算表达式调试框，查看该输入内容的调试结果\r\n8.  Alt + Home   定位 / 显示到当前文件的 Navigation Bar\r\n9.  Alt + Enter  IntelliJ IDEA 根据光标所在问题，提供快速修复选择，光标放在的位置不同提示的结果也不同 （必备）\r\n10.  Alt + Insert 代码自动生成，如生成对象的 set / get 方法，构造函数，toString() 等 （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Alt  +  左方向键  切换当前已打开的窗口中的子视图，比如  Debug  窗口中有  Output、Debugger  等子视图，用此快捷键就可以在子视图中切换  （必备）\r\n2.  Alt  +  右方向键  按切换当前已打开的窗口中的子视图，比如  Debug  窗口中有  Output、Debugger  等子视图，用此快捷键就可以在子视图中切换  （必备）\r\n3.  Alt  +  前方向键  当前光标跳转到当前文件的前一个方法名位置  （必备）\r\n4.  Alt  +  后方向键  当前光标跳转到当前文件的后一个方法名位置  （必备）\r\n5.  Alt  +1,2,3...9  显示对应数值的选项卡，其中  1  是  Project  用得最多  （必备）\r\n\r\n三、Shift 快捷键\r\n-----------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Shift  + F1 如果有外部文档可以连接外部文档\r\n2.  Shift  + F2 跳转到上一个高亮错误  或  警告位置\r\n3.  Shift  + F3 在查找模式下，查找匹配上一个\r\n4.  Shift  + F4 对当前打开的文件，使用新  Windows  窗口打开，旧窗口保留\r\n5.  Shift  + F6 对文件  /  文件夹  重命名\r\n6.  Shift  + F7 在  Debug  模式下，智能步入。断点所在行上有多个方法调用，会弹出进入哪个方法\r\n7.  Shift  + F8 在  Debug  模式下，跳出，表现出来的效果跟 F9 一样\r\n8.  Shift  + F9 等效于点击工具栏的  Debug  按钮\r\n9.  Shift  + F10 等效于点击工具栏的  Run  按钮\r\n10.  Shift  + F11 弹出书签显示层  （必备）\r\n11.  Shift  +  Tab  取消缩进  （必备）\r\n12.  Shift  + ESC 隐藏当前  或  最后一个激活的工具窗口\r\n13.  Shift  +  End  选中光标到当前行尾位置\r\n14.  Shift  +  Home  选中光标到当前行头位置\r\n15.  Shift  +  Enter  开始新一行。光标所在行下空出一行，光标定位到新行位置  （必备）\r\n16.  Shift  +  左键单击  在打开的文件名上按此快捷键，可以关闭当前打开文件  （必备）\r\n17.  Shift  +  滚轮前后滚动  当前文件的横向滚动轴滚动  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n四、Ctrl + Alt 快捷键\r\n----------------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Alt  + L 格式化代码，可以对当前文件和整个包目录使用  （必备）\r\n2.  Ctrl  +  Alt  + O 优化导入的类，可以对当前文件和整个包目录使用  （必备）\r\n3.  Ctrl  +  Alt  + I 光标所在行  或  选中部分进行自动代码缩进，有点类似格式化\r\n4.  Ctrl  +  Alt  + T 对选中的代码弹出环绕选项弹出层  （必备）\r\n5.  Ctrl  +  Alt  + J 弹出模板选择窗口，将选定的代码加入动态模板中\r\n6.  Ctrl  +  Alt  + H 调用层次\r\n7.  Ctrl  +  Alt  + B 在某个调用的方法名上使用会跳到具体的实现处，可以跳过接口\r\n8.  Ctrl  +  Alt  + V 快速引进变量\r\n9.  Ctrl  +  Alt  + Y 同步、刷新\r\n10.  Ctrl  +  Alt  + S 打开  IntelliJ IDEA 系统设置  （必备）\r\n11.  Ctrl  +  Alt  + F7 显示使用的地方。寻找被该类或是变量被调用的地方，用弹出框的方式找出来\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Alt  + F11 切换全屏模式\r\n2.  Ctrl  +  Alt  +  Enter  光标所在行上空出一行，光标定位到新行  （必备）\r\n3.  Ctrl  +  Alt  +  Home  弹出跟当前文件有关联的文件弹出层\r\n4.  Ctrl  +  Alt  +  Space  类名自动完成\r\n5.  Ctrl  +  Alt  +  左方向键  退回到上一个操作的地方  （必备）\r\n6.  Ctrl  +  Alt  +  右方向键  前进到上一个操作的地方  （必备）\r\n7.  Ctrl  +  Alt  +  前方向键  在查找模式下，跳到上个查找的文件\r\n8.  Ctrl  +  Alt  +  后方向键  在查找模式下，跳到下个查找的文件\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n五、Ctrl + Shift 快捷键\r\n------------------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Shift  + F 根据输入内容查找整个项目  或  指定目录内文件  （必备）\r\n2.  Ctrl  +  Shift  + R 根据输入内容替换对应内容，范围为整个项目  或  指定目录内文件  （必备）\r\n3.  Ctrl  +  Shift  + J 自动将下一行合并到当前行末尾  （必备）\r\n4.  Ctrl  +  Shift  + Z 取消撤销  （必备）\r\n5.  Ctrl  +  Shift  + W 递进式取消选择代码块。可选中光标所在的单词或段落，连续按会在原有选中的基础上再扩展取消选中范围  （必备）\r\n6.  Ctrl  +  Shift  + N 通过文件名定位  /  打开文件  /  目录，打开目录需要在输入的内容后面多加一个正斜杠  （必备）\r\n7.  Ctrl  +  Shift  + U 对选中的代码进行大  /  小写轮流转换  （必备）\r\n8.  Ctrl  +  Shift  + T 对当前类生成单元测试类，如果已经存在的单元测试类则可以进行选择  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Shift  + C 复制当前文件磁盘路径到剪贴板  （必备）\r\n2.  Ctrl  +  Shift  + V 弹出缓存的最近拷贝的内容管理器弹出层\r\n3.  Ctrl  +  Shift  + E 显示最近修改的文件列表的弹出层\r\n4.  Ctrl  +  Shift  + H 显示方法层次结构\r\n5.  Ctrl  +  Shift  + B 跳转到类型声明处  （必备）\r\n6.  Ctrl  +  Shift  + I 快速查看光标所在的方法  或  类的定义\r\n7.  Ctrl  +  Shift  + A 查找动作  /  设置\r\n8.  Ctrl  +  Shift  +  /  代码块注释  （必备）\r\n9.  Ctrl  +  Shift  +  \\[  选中从光标所在位置到它的顶部中括号位置  （必备）\r\n10.  Ctrl  +  Shift  +  \\]  选中从光标所在位置到它的底部中括号位置  （必备）\r\n11.  Ctrl  +  Shift  +  +  展开所有代码  （必备）\r\n12.  Ctrl  +  Shift  +  -  折叠所有代码  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Shift  + F7 高亮显示所有该选中文本，按  Esc  高亮消失  （必备）\r\n2.  Ctrl  +  Shift  + F8 在  Debug  模式下，指定断点进入条件\r\n3.  Ctrl  +  Shift  + F9 编译选中的文件  /  包  /  Module\r\n4.  Ctrl  +  Shift  + F12 编辑器最大化  （必备）\r\n5.  Ctrl  +  Shift  +  Space  智能代码提示\r\n6.  Ctrl  +  Shift  +  Enter  自动结束代码，行末自动添加分号  （必备）\r\n7.  Ctrl  +  Shift  +Backspace  退回到上次修改的地方  （必备）\r\n8.  Ctrl  +  Shift  +1,2,3...9  快速添加指定数值的书签  （必备）\r\n9.  Ctrl  +  Shift  +  左键单击  把光标放在某个类变量上，按此快捷键可以直接定位到该类中  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Ctrl  +  Shift  +  左方向键  在代码文件上，光标跳转到当前单词  /  中文句的左侧开头位置，同时选中该单词  /  中文句（必备） \r\n2.  Ctrl  +  Shift  +  右方向键  在代码文件上，光标跳转到当前单词  /  中文句的右侧开头位置，同时选中该单词  /  中文句（必备）\r\n3.  Ctrl  +  Shift  +  前方向键  光标放在方法名上，将方法移动到上一个方法前面，调整方法排序  （必备）\r\n4.  Ctrl  +  Shift  +  后方向键  光标放在方法名上，将方法移动到下一个方法前面，调整方法排序  （必备）\r\n\r\n六、Alt + Shift 快捷键\r\n-----------------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  Alt  +  Shift  + N 选择  /  添加 task （必备）\r\n2.  Alt  +  Shift  + F 显示添加到收藏夹弹出层  /  添加到收藏夹\r\n3.  Alt  +  Shift  + C 查看最近操作项目的变化情况列表\r\n4.  Alt  +  Shift  + I 查看项目当前文件\r\n5.  Alt  +  Shift  + F7在  Debug  模式下，下一步，进入当前方法体内，如果方法体还有方法，则会进入该内嵌的方法中，依此循环进入\r\n6.  Alt  +  Shift  + F9 弹出  Debug  的可选择菜单\r\n7.  Alt  +  Shift  + F10 弹出  Run  的可选择菜单\r\n8.  Alt  +  Shift  +  左键双击  选择被双击的单词  /  中文句，按住不放，可以同时选择其他单词  /  中文句  （必备）\r\n9.  Alt  +  Shift  +  前方向键  移动光标所在行向上移动  （必备）\r\n10.  Alt  +  Shift  +  后方向键  移动光标所在行向下移动  （必备）\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n七、Ctrl + Shift + Alt 快捷键\r\n------------------------\r\n\r\n1.  Ctrl  +  Shift  +  Alt  + V 无格式黏贴  （必备）\r\n2.  Ctrl  +  Shift  +  Alt  + N 前往指定的变量  /  方法\r\n3.  Ctrl  +  Shift  +  Alt  + S 打开当前项目设置  （必备）\r\n4.  Ctrl  +  Shift  +  Alt  + C 复制参考信息\r\n\r\n八、其他快捷键\r\n-------\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n1.  F2 跳转到下一个高亮错误  或  警告位置  （必备）\r\n2.  F3 在查找模式下，定位到下一个匹配处\r\n3.  F4 编辑源  （必备）\r\n4.  F7 在  Debug  模式下，进入下一步，如果当前行断点是一个方法，则进入当前方法体内，如果该方法体还有方法，则不会进入该内嵌的方法中\r\n5.  F8 在  Debug  模式下，进入下一步，如果当前行断点是一个方法，则不进入当前方法体内\r\n6.  F9 在  Debug  模式下，恢复程序运行，但是如果该断点下面代码还有断点则停在下一个断点上\r\n7.  F11 添加书签  （必备）\r\n8.  F12 回到前一个工具窗口  （必备）\r\n9.  Tab缩进  （必备）\r\n10.  ESC 从工具窗口进入代码文件窗口  （必备）\r\n11.  连按两次Shift  弹出  Search  Everywhere  弹出层','2018-08-28 16:26:46','https://picsum.photos/800/450/?1006',NULL,'','','','IDEA常用快捷键','2018-08-28 16:26:46',0,2,1),(2,'','','[git命令清单](https://www.cnblogs.com/xinzhihen/p/9547326.html)\r\n===========================================================\r\n\r\n一、新建代码库\r\n\r\n\\# 在当前目录新建一个Git代码库\r\n\r\n$ git init\r\n\r\n\\# 新建一个目录，将其初始化为Git代码库\r\n\r\n$ git init \\[project-name\\]\r\n\r\n\\# 下载一个项目和它的整个代码历史\r\n\r\n$ git clone \\[url\\]\r\n\r\n二、配置\r\n\r\nGit的设置文件为.gitconfig，它可以在用户主目录下（全局配置），也可以在项目目录下（项目配置）。\r\n\r\n\\# 显示当前的Git配置\r\n\r\n$ git config --list\r\n\r\n\\# 编辑Git配置文件\r\n\r\n$ git config -e \\[--global\\]\r\n\r\n\\# 设置提交代码时的用户信息\r\n\r\n$ git config \\[--global\\] user.name \"\\[name\\]\"\r\n\r\n$ git config \\[--global\\] user.email \"\\[email address\\]\"\r\n\r\n三、增加/删除文件\r\n\r\n\\# 添加指定文件到暂存区\r\n\r\n$ git add \\[file1\\] \\[file2\\] ...\r\n\r\n\\# 添加指定目录到暂存区，包括子目录\r\n\r\n$ git add \\[dir\\]\r\n\r\n\\# 添加当前目录的所有文件到暂存区\r\n\r\n$ git add .\r\n\r\n\\# 添加每个变化前，都会要求确认\r\n\r\n\\# 对于同一个文件的多处变化，可以实现分次提交\r\n\r\n$ git add -p\r\n\r\n\\# 删除工作区文件，并且将这次删除放入暂存区\r\n\r\n$ git rm \\[file1\\] \\[file2\\] ...\r\n\r\n\\# 停止追踪指定文件，但该文件会保留在工作区\r\n\r\n$ git rm --cached \\[file\\]\r\n\r\n\\# 改名文件，并且将这个改名放入暂存区\r\n\r\n$ git mv \\[file-original\\] \\[file-renamed\\]\r\n\r\n四、代码提交\r\n\r\n\\# 提交暂存区到仓库区\r\n\r\n$ git commit -m \\[message\\]\r\n\r\n\\# 提交暂存区的指定文件到仓库区\r\n\r\n$ git commit \\[file1\\] \\[file2\\] ... -m \\[message\\]\r\n\r\n\\# 提交工作区自上次commit之后的变化，直接到仓库区\r\n\r\n$ git commit -a\r\n\r\n\\# 提交时显示所有diff信息\r\n\r\n$ git commit -v\r\n\r\n\\# 使用一次新的commit，替代上一次提交\r\n\r\n\\# 如果代码没有任何新变化，则用来改写上一次commit的提交信息\r\n\r\n$ git commit --amend -m \\[message\\]\r\n\r\n\\# 重做上一次commit，并包括指定文件的新变化\r\n\r\n$ git commit --amend \\[file1\\] \\[file2\\] ...\r\n\r\n五、分支\r\n\r\n\\# 列出所有本地分支\r\n\r\n$ git branch\r\n\r\n\\# 列出所有远程分支\r\n\r\n$ git branch -r\r\n\r\n\\# 列出所有本地分支和远程分支\r\n\r\n$ git branch -a\r\n\r\n\\# 新建一个分支，但依然停留在当前分支\r\n\r\n$ git branch \\[branch-name\\]\r\n\r\n\\# 新建一个分支，并切换到该分支\r\n\r\n$ git checkout -b \\[branch\\]\r\n\r\n\\# 新建一个分支，指向指定commit\r\n\r\n$ git branch \\[branch\\] \\[commit\\]\r\n\r\n\\# 新建一个分支，与指定的远程分支建立追踪关系\r\n\r\n$ git branch --track \\[branch\\] \\[remote-branch\\]\r\n\r\n\\# 切换到指定分支，并更新工作区\r\n\r\n$ git checkout \\[branch-name\\]\r\n\r\n\\# 切换到上一个分支\r\n\r\n$ git checkout -\r\n\r\n\\# 建立追踪关系，在现有分支与指定的远程分支之间\r\n\r\n$ git branch --set-upstream \\[branch\\] \\[remote-branch\\]\r\n\r\n\\# 合并指定分支到当前分支\r\n\r\n$ git merge \\[branch\\]\r\n\r\n\\# 选择一个commit，合并进当前分支\r\n\r\n$ git cherry-pick \\[commit\\]\r\n\r\n\\# 删除分支\r\n\r\n$ git branch -d \\[branch-name\\]\r\n\r\n\\# 删除远程分支\r\n\r\n$ git push origin --delete \\[branch-name\\]\r\n\r\n$ git branch -dr \\[remote/branch\\]\r\n\r\n六、标签\r\n\r\n\\# 列出所有tag\r\n\r\n$ git tag\r\n\r\n\\# 新建一个tag在当前commit\r\n\r\n$ git tag \\[tag\\]\r\n\r\n\\# 新建一个tag在指定commit\r\n\r\n$ git tag \\[tag\\] \\[commit\\]\r\n\r\n\\# 删除本地tag\r\n\r\n$ git tag -d \\[tag\\]\r\n\r\n\\# 删除远程tag\r\n\r\n$ git push origin :refs/tags/\\[tagName\\]\r\n\r\n\\# 查看tag信息\r\n\r\n$ git show \\[tag\\]\r\n\r\n\\# 提交指定tag\r\n\r\n$ git push \\[remote\\] \\[tag\\]\r\n\r\n\\# 提交所有tag\r\n\r\n$ git push \\[remote\\] --tags\r\n\r\n\\# 新建一个分支，指向某个tag\r\n\r\n$ git checkout -b \\[branch\\] \\[tag\\]\r\n\r\n七、查看信息\r\n\r\n\\# 显示有变更的文件\r\n\r\n$ git status\r\n\r\n\\# 显示当前分支的版本历史\r\n\r\n$ git log\r\n\r\n\\# 显示commit历史，以及每次commit发生变更的文件\r\n\r\n$ git log --stat\r\n\r\n\\# 搜索提交历史，根据关键词\r\n\r\n$ git log -S \\[keyword\\]\r\n\r\n\\# 显示某个commit之后的所有变动，每个commit占据一行\r\n\r\n$ git log \\[tag\\] HEAD --pretty=format:%s\r\n\r\n\\# 显示某个commit之后的所有变动，其\"提交说明\"必须符合搜索条件\r\n\r\n$ git log \\[tag\\] HEAD --grep feature\r\n\r\n\\# 显示某个文件的版本历史，包括文件改名\r\n\r\n$ git log --follow \\[file\\]\r\n\r\n$ git whatchanged \\[file\\]\r\n\r\n\\# 显示指定文件相关的每一次diff\r\n\r\n$ git log -p \\[file\\]\r\n\r\n\\# 显示过去5次提交\r\n\r\n$ git log -5 --pretty --oneline\r\n\r\n\\# 显示所有提交过的用户，按提交次数排序\r\n\r\n$ git shortlog -sn\r\n\r\n\\# 显示指定文件是什么人在什么时间修改过\r\n\r\n$ git blame \\[file\\]\r\n\r\n\\# 显示暂存区和工作区的差异\r\n\r\n$ git diff\r\n\r\n\\# 显示暂存区和上一个commit的差异\r\n\r\n$ git diff --cached \\[file\\]\r\n\r\n\\# 显示工作区与当前分支最新commit之间的差异\r\n\r\n$ git diff HEAD\r\n\r\n\\# 显示两次提交之间的差异\r\n\r\n$ git diff \\[first-branch\\]...\\[second-branch\\]\r\n\r\n\\# 显示今天你写了多少行代码\r\n\r\n$ git diff --shortstat \"@{0 day ago}\"\r\n\r\n\\# 显示某次提交的元数据和内容变化\r\n\r\n$ git show \\[commit\\]\r\n\r\n\\# 显示某次提交发生变化的文件\r\n\r\n$ git show --name-only \\[commit\\]\r\n\r\n\\# 显示某次提交时，某个文件的内容\r\n\r\n$ git show \\[commit\\]:\\[filename\\]\r\n\r\n\\# 显示当前分支的最近几次提交\r\n\r\n$ git reflog\r\n\r\n八、远程同步\r\n\r\n\\# 下载远程仓库的所有变动\r\n\r\n$ git fetch \\[remote\\]\r\n\r\n\\# 显示所有远程仓库\r\n\r\n$ git remote -v\r\n\r\n\\# 显示某个远程仓库的信息\r\n\r\n$ git remote show \\[remote\\]\r\n\r\n\\# 增加一个新的远程仓库，并命名\r\n\r\n$ git remote add \\[shortname\\] \\[url\\]\r\n\r\n\\# 取回远程仓库的变化，并与本地分支合并\r\n\r\n$ git pull \\[remote\\] \\[branch\\]\r\n\r\n\\# 上传本地指定分支到远程仓库\r\n\r\n$ git push \\[remote\\] \\[branch\\]\r\n\r\n\\# 强行推送当前分支到远程仓库，即使有冲突\r\n\r\n$ git push \\[remote\\] --force\r\n\r\n\\# 推送所有分支到远程仓库\r\n\r\n$ git push \\[remote\\] --all\r\n\r\n九、撤销\r\n\r\n\\# 恢复暂存区的指定文件到工作区\r\n\r\n$ git checkout \\[file\\]\r\n\r\n\\# 恢复某个commit的指定文件到暂存区和工作区\r\n\r\n$ git checkout \\[commit\\] \\[file\\]\r\n\r\n\\# 恢复暂存区的所有文件到工作区\r\n\r\n$ git checkout .\r\n\r\n\\# 重置暂存区的指定文件，与上一次commit保持一致，但工作区不变\r\n\r\n$ git reset \\[file\\]\r\n\r\n\\# 重置暂存区与工作区，与上一次commit保持一致\r\n\r\n$ git reset --hard\r\n\r\n\\# 重置当前分支的指针为指定commit，同时重置暂存区，但工作区不变\r\n\r\n$ git reset \\[commit\\]\r\n\r\n\\# 重置当前分支的HEAD为指定commit，同时重置暂存区和工作区，与指定commit一致\r\n\r\n$ git reset --hard \\[commit\\]\r\n\r\n\\# 重置当前HEAD为指定commit，但保持暂存区和工作区不变\r\n\r\n$ git reset --keep \\[commit\\]\r\n\r\n\\# 新建一个commit，用来撤销指定commit\r\n\r\n\\# 后者的所有变化都将被前者抵消，并且应用到当前分支\r\n\r\n$ git revert \\[commit\\]\r\n\r\n\\# 暂时将未提交的变化移除，稍后再移入\r\n\r\n$ git stash\r\n\r\n$ git stash pop\r\n\r\n十、其他\r\n\r\n\\# 生成一个可供发布的压缩包\r\n\r\n$ git archive','2018-08-28 16:41:07','https://picsum.photos/800/450/?1008',NULL,'','','','git基本命令','2018-08-28 16:41:07',0,2,1),(3,'','','[【算法】二叉树的前序、中序、后序、层序遍历和还原。](https://www.cnblogs.com/yanyojun/p/9488452.html)\r\n============================================================================\r\n\r\n一、构建二叉树\r\n-------\r\n\r\n我们构建一个如下图所示的二叉树：\r\n\r\n![](https://images2018.cnblogs.com/blog/426077/201808/426077-20180816170242200-565141450.png)\r\n\r\n我们使用下面的数据结构来描绘出这个二叉树\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1 public class Node { 2     private String name = \"\";\r\n 3     public Node leftChild; 4     public Node rightChild; 5 \r\n 6     public Node(String name) { 7         this.name = name; 8     }\r\n 9 \r\n10     public Node() { 11 } 12 \r\n13     public void setName(String name) { 14         this.name = name; 15     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n二、二叉树的遍历\r\n--------\r\n\r\n前序遍历：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 前序遍历\r\n 3      */\r\n 4     public String readPre() { 5         StringBuilder result = new StringBuilder(); 6         result.append(name); //前序遍历\r\n 7         if (leftChild != null) {\r\n 8             result.append(leftChild.readPre());\r\n 9 } 10         if (rightChild != null) { 11 result.append(rightChild.readPre()); 12 } 13         return result.toString(); 14     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n中序遍历：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 中序遍历\r\n 3      */\r\n 4     public String readMid() { 5         StringBuilder result = new StringBuilder(); 6         if (leftChild != null) {\r\n 7             result.append(leftChild.readMid());\r\n 8         }\r\n 9         result.append(name); //中序遍历\r\n10         if (rightChild != null) { 11 result.append(rightChild.readMid()); 12 } 13         return result.toString(); 14     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n后序遍历：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 后序遍历\r\n 3      */\r\n 4     public String readEnd() { 5         StringBuilder result = new StringBuilder(); 6         if (leftChild != null) {\r\n 7             result.append(leftChild.readEnd());\r\n 8         }\r\n 9         if (rightChild != null) { 10 result.append(rightChild.readEnd()); 11 } 12         result.append(name); //后序遍历\r\n13         return result.toString(); 14     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n从上面可以看到，前序、中序、后序遍历的算法基本上差不多，其主要是在对根节点的访问顺序不同，然后利用递归的方式来进行实现。\r\n\r\n层序遍历：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 层序遍历\r\n 3      */\r\n 4     public String readLevel() { 5         Queue<Node> queue = new LinkedList<>();\r\n 6         StringBuilder result = new StringBuilder(); 7         queue.offer(this);\r\n 8         while (!queue.isEmpty()) {\r\n 9             Node curNode = queue.poll(); 10 result.append(curNode.name); 11             if (curNode.leftChild != null) { 12 queue.offer(curNode.leftChild); 13 } 14             if (curNode.rightChild != null) { 15 queue.offer(curNode.rightChild); 16 } 17 } 18         return result.toString(); 19     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n跟其他遍历不同，层序遍历需要借助队列来进行实现。首先将根节点放到队列中，然后遍历循环，依次将左孩子和右孩子放置到队列中。\r\n\r\n三、还原二叉树\r\n-------\r\n\r\n在第二章节中，获得到前序、中序、后序、层序的结果依次如下：\r\n\r\n1         String pre = \"ABDGHCEIF\"; //前序遍历\r\n2         String mid = \"GDHBAEICF\"; //中序遍历\r\n3         String end = \"GHDBIEFCA\"; //后序遍历\r\n4         String level = \"ABCDEFGHI\"; //层序遍历\r\n\r\n那能否通过上面的字符串还原出二叉树的的形状呢？这个分情况讨论\r\n\r\n**前序+中序：**\r\n\r\n思路：通过前序获得根节点的位置，利用根节点将中序序列分为左子树和右子树，然后不断的递归划分即可。\r\n\r\n代码：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 根据前序和中序排序表获取树\r\n 3      */\r\n 4     private static Node buildTreeByPreMid(char\\[\\] pre, int preBegin, int preEnd, char\\[\\] mid, int midBegin, int midEnd) { 5         Node root = new Node(); 6         root.setName(pre\\[preBegin\\] + \"\");\r\n 7 \r\n 8         int midRootLoc = 0;\r\n 9         for (int i = midBegin; i <= midEnd; i++) { 10             if (mid\\[i\\] == pre\\[preBegin\\]) { 11                 midRootLoc = i; 12                 break; 13 } 14 } 15 \r\n16         //递归得到左子树\r\n17         if (preBegin + (midRootLoc - midBegin) >= preBegin + 1 && (midRootLoc - 1) >= midBegin) { 18             Node leftChild = buildTreeByPreMid(pre, preBegin + 1, preBegin + (midRootLoc - midBegin), 19                     mid, midBegin, midRootLoc - 1); 20             root.leftChild = leftChild; 21 } 22 \r\n23         //递归得到右子树\r\n24         if (preEnd >= (preEnd - (midEnd - midRootLoc) + 1) && (midEnd >= midRootLoc + 1)) { 25             Node rightChild = buildTreeByPreMid(pre, preEnd - (midEnd - midRootLoc) + 1, preEnd, 26                     mid, midRootLoc + 1, midEnd); 27             root.rightChild = rightChild; 28 } 29 \r\n30         return root; 31     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n**后序+中序：**  \r\n思路：通过后序获取根节点的位置，然后在中序中划分左子树和右子树，然后递归划分即可。\r\n\r\n代码：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 根据后序和中序遍历还原树\r\n 3      */\r\n 4     private static Node buildTreeByMidEnd(char\\[\\] mid, int midBegin, int midEnd, char\\[\\] end, int endBegin, int endEnd) { 5         Node root = new Node(); 6         root.setName(end\\[endEnd\\] + \"\");\r\n 7         int midRootLoc = 0;\r\n 8         for (int i = midEnd; i >= midBegin; i--) {\r\n 9             if (mid\\[i\\] == end\\[endEnd\\]) { 10                 midRootLoc = i; 11                 break; 12 } 13 } 14 \r\n15         //还原左子树\r\n16         if (midRootLoc - 1 >= midBegin && (endBegin + (midRootLoc - midBegin) - 1 >= endBegin)) { 17             Node leftChild = buildTreeByMidEnd(mid, midBegin, midRootLoc - 1, end, endBegin, endBegin + (midRootLoc - midBegin) - 1); 18             root.leftChild = leftChild; 19 } 20 \r\n21         //还原右子树\r\n22         if (midEnd >= midRootLoc + 1 && (endEnd - 1 >= endEnd - (midEnd - midRootLoc))) { 23             Node rightChild = buildTreeByMidEnd(mid, midRootLoc + 1, midEnd, end, endEnd - (midEnd - midRootLoc), endEnd - 1); 24             root.rightChild = rightChild; 25 } 26 \r\n27         return root; 28     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n**层序+中序：**\r\n\r\n思路：根据层序遍历获取根节点的位置，然后将中序划分为左子树和右子树，然后根据划分出的左子树和右子树分别在层序遍历中获取其对应的层序顺序，然后递归调用划分即可。\r\n\r\n代码如下：\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n 1     /**\r\n 2      \\* 根据层序遍历和中序遍历得到结果\r\n 3 \\* @return\r\n 4      */\r\n 5     private static Node buildTreeByMidLevel(char\\[\\] mid, char\\[\\] level, int midBegin, int midEnd) { 6         Node root = new Node(level\\[0\\] + \"\");\r\n 7 \r\n 8         int midLoc = -1;\r\n 9         for (int i = midBegin; i <= midEnd; i++) { 10             if (mid\\[i\\] == level\\[0\\]) { 11                 midLoc = i; 12                 break; 13 } 14 } 15 \r\n16         if (level.length >= 2) { 17             if (isLeft(mid, level\\[0\\], level\\[1\\])) { 18                 Node left = buildTreeByMidLevel(mid, getLevelStr(mid, midBegin, midLoc - 1, level), midBegin, midLoc - 1); 19                 root.leftChild = left; 20                 if (level.length >= 3 && !isLeft(mid, level\\[0\\], level\\[2\\])) { 21                     Node right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd); 22                     root.rightChild = right; 23 } 24             } else { 25                 Node right = buildTreeByMidLevel(mid, getLevelStr(mid, midLoc + 1, midEnd, level), midLoc + 1, midEnd); 26                 root.rightChild = right; 27 } 28 } 29         return root; 30 } 31 \r\n32     /**\r\n33 \\* 将中序序列中midBegin与MidEnd的字符依次从level中提取出来，保持level中的字符顺序不变 34      */\r\n35     private static char\\[\\] getLevelStr(char\\[\\] mid, int midBegin, int midEnd, char\\[\\] level) { 36         char\\[\\] result = new char\\[midEnd - midBegin + 1\\]; 37         int curLoc = 0; 38         for (int i = 0; i < level.length; i++) { 39             if (contains(mid, level\\[i\\], midBegin, midEnd)) { 40                 result\\[curLoc++\\] = level\\[i\\]; 41 } 42 } 43         return result; 44 } 45 \r\n46     /**\r\n47 \\* 如果str字符串的begin和end位置之间（包括begin和end）含有字符target,则返回true。 48      */\r\n49     private static boolean contains(char\\[\\] str, char target, int begin, int end) { 50         for (int i = begin; i <= end; i++) { 51             if (str\\[i\\] == target) { 52                 return true; 53 } 54 } 55         return false; 56     }\r\n\r\n[![复制代码](//common.cnblogs.com/images/copycode.gif)](javascript:void(0); \"复制代码\")\r\n\r\n**其他的遍历组合均不能还原出二叉树的形状，因为无法确认其左右孩子。例如，前序为AB，后序为AB，则无法确认出，B节点是A节点的左孩子还是右孩子，因此无法还原。**\r\n\r\n完整代码已经上传至GitHub：\r\n\r\n[https://github.com/YanYoJun/Tree](https://github.com/YanYoJun/Tree)\r\n\r\n','2018-08-28 17:13:56','https://picsum.photos/800/450/?1007',NULL,'','','','二叉树','2018-08-28 17:13:56',0,15,1),(4,'','','[【IDEA 快速搭建 SpringBoot工程】](https://www.cnblogs.com/MarsCxy/p/9545449.html)\r\n==========================================================================\r\n\r\nIDEA 版本：2018.2.1\r\n\r\n1.点击 File——New——Project\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827223344380-1557473406.png)\r\n\r\n2.选择SpringInitializr和Jdk, 点击 next\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827223621314-108272178.png)\r\n\r\n3.设置相关包名  工程类型选择MavenProject 点击next\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827223912923-2067743780.png)\r\n\r\n4.配置Web相关依赖，搜索\'web\'点击第一个，IDEA会为你的项目装载web相关的模块\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827224538467-862812295.png)\r\n\r\n5.编辑项目名称和项目地址，点击Finish      到此一个基于SpringBoot的工程就搭建完成了\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827224836241-55311255.png)\r\n\r\n6.搭建完成后可以看到项目的结构\r\n\r\n因为SpringBoot内置了Tomcat,运行DemoApplication的main函数即可启动项目，当然也可以通过Maven把工程打成Jar包直接运行或者打成War包放到Tomcat下运行\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827225341010-1155724592.png)\r\n\r\n7.接下来写一个简单的Controller运行测试\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827230338405-815857226.png)\r\n\r\n 8.运行DemoApplication的main函数启动程序\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827230454463-1587516448.png)\r\n\r\n9.在浏览器中访问http://localhost:8080/test/helloworld即可看到我们刚刚所写Controller的返回内容\r\n\r\n![](https://images2018.cnblogs.com/blog/1245463/201808/1245463-20180827230652369-160316300.png)\r\n\r\n10.总结\r\n\r\n到此我们可以看到，使用SpringBoot创建工程非常方便简洁，我们省略了Maven依赖包和Springmvc控制器的很多配置内容，创建项目可以直接进行业务层面的开发，显著提高了开发的工作效率\r\n\r\n','2018-08-28 17:16:12','https://picsum.photos/800/450/?1005',NULL,'','','','IDEA构建springboot项目','2018-08-28 17:16:12',0,2,1);

/*Table structure for table `t_blog_tags` */

DROP TABLE IF EXISTS `t_blog_tags`;

CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint(20) NOT NULL,
  `tags_id` bigint(20) NOT NULL,
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_blog_tags` */

insert  into `t_blog_tags`(`blogs_id`,`tags_id`) values (1,1),(2,1),(3,1),(4,1);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  KEY `FK4jj284r3pb7japogvo6h72q95` (`parent_comment_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

/*Table structure for table `t_tag` */

DROP TABLE IF EXISTS `t_tag`;

CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_tag` */

insert  into `t_tag`(`id`,`name`) values (1,'Java'),(3,'HTML'),(4,'JavaScript');

/*Table structure for table `t_type` */

DROP TABLE IF EXISTS `t_type`;

CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_type` */

insert  into `t_type`(`id`,`name`) values (1,'HTML'),(2,'Java'),(3,'JavaScript'),(4,'web'),(5,'Linux'),(6,'Redis'),(7,'Nginx'),(8,'MySQL'),(9,'Oracle'),(10,'tomcat'),(11,'play'),(12,'CSS'),(13,'错误日志'),(15,'算法');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`avatar`,`create_time`,`email`,`password`,`type`,`update_time`,`user_name`,`nick_name`) values (1,'https://unsplash.it/50/50?image=1005','2018-08-20 15:41:45','947751771@qq.com','e10adc3949ba59abbe56e057f20f883e',1,'2018-08-20 15:42:12','admin','huhan66');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
