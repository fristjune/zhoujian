Step 1.Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
 
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.fristjune:ZhoujianDemo:-SNAPSHOT'
	}
	
Step 3.通过一行代码即可实现阴影效果：

ShadowDrawable.setShadowDrawable(textView1, Color.parseColor("#3D5AFE"), dpToPx(8),
    Color.parseColor("#66000000"), dpToPx(10), 0, 0);
  
  
Step 4.通过一行代码即可实现阴影效果：[图片]
