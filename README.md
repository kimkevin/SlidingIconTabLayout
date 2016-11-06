# SlidingIconTabLayout Sample

A basic sample which shows how to use `SlidingTabLayout` with not only Text but also Icon for tab layout. 

<img src="./screenshot/screenshot_01.png" width=200 height=355 />
<img src="./screenshot/screenshot_02.png" width=200 height=355 />

# Download

```java
repositories {
	jcenter()
}

dependencies {
	compile 'com.github.kimkevin:slidingicontablayout:1.0.0'
}
```

# Usage
For using icon for tab, implement `SlidingTabLayout.TabIconProvider` to your `FragmentPagerAdapter` as below.

```java
public class BaseTabAdapter extends FragmentPagerAdapter implements SlidingTabLayout.TabIconProvider {
    private static final int iconRes[] = {
            R.drawable.ic_action_camera,
            R.drawable.ic_action_video
    };

    ...
    
    @Override
    public int getPageIconResId(int position) {
        return iconRes[position];
    }
}
```

# Developed By
* Kevin Yongjun Kim - imkimkevin@gmail.com

# Contributing
All contributions are welcome. Open a [Pull Requests](https://github.com/kimkevin/SlidingIconTabLayout/pulls) or refer to
the [Issues](https://github.com/kimkevin/SlidingIconTabLayout/issues) section.

# License
MIT
