# PrefereceFragmentTest
the fourth dormitory
# 实验内容
使用PreferenceFragment实现设置页面
# 关键代码
## PreferenceFragment布局
```
<?xml version="1.0" encoding="utf-8"?>
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    >
    <PreferenceCategory android:title="In-line preferences">
        <CheckBoxPreference
            android:title="Checkbox preference"
            android:summary="This is a checkbox"
            android:key="cbp1"
            />
    </PreferenceCategory>
    <PreferenceCategory android:title="Dialog-based preference">
        <EditTextPreference
            android:title="Edit text preference"
            android:dialogTitle="Enter your favorite animal"
            android:summary="An example that uses an edit text dialog"
            android:key="etp1"
            />
        <ListPreference
            android:title="List preference"
            android:dialogTitle="Choose one"
            android:summary="An example that uses a list dialog"
            android:entries="@array/example"
            android:entryValues="@array/example"
            />
    </PreferenceCategory>
    <PreferenceCategory android:title="Launches preference">
        <PreferenceScreen
            android:title="Screen preference"
            android:summary="show another screen of preferences"
            >
            <CheckBoxPreference
                android:title="Toggle preference"
                android:summary="Preference that is on the next screen but same hierarchy"
                android:key="cbp2"
                />
        </PreferenceScreen>
        <PreferenceScreen
            android:title="Intent preference"
            android:summary="Launches a activity from a intent ">
            <intent android:action="android.intent.action.VIEW"
                android:data="http://www.baidu.com"/>
        </PreferenceScreen>
    </PreferenceCategory>
    <PreferenceCategory android:title="Preference attribute">
        <CheckBoxPreference
            android:key="parent"
            android:title="Parent checkbox preference"
            android:summary="This is visually a parent"
            />
        <CheckBoxPreference
            android:dependency="parent"
            android:title="Child checkbox preference"
            android:summary="This is visually a child"
            android:key="cbp3"/>
    </PreferenceCategory>
</PreferenceScreen>

```
## PreferenceFragment加载使用
```
public class PreferencerFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
```
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        PreferencerFragment preferencerFragment=new PreferencerFragment();
        fragmentTransaction.add(R.id.main, preferencerFragment);
        fragmentTransaction.commit();
    }
}
```
# 实验截图
## 主界面
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/generalperspect1.jpg)
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/generalperspect2.jpg)
## EditText Dialog
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/editdialog.jpg)
## List Dialog
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/listdialog.jpg)
## 跳转到另一个PreferenceScreen
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/c27563d18da70ca943dfd6712197cf5ff905ff9a/pictures/jump.jpg)
## 父选项勾选子选项可选
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/dependencyinit.jpg)
![](https://github.com/smartflowers/PrefereceFragmentTest/blob/master/pictures/dependencychange.jpg)
