# 博学谷 (BoXueGu)

博学谷是一款 Android 端在线教育学习应用，提供课程学习、在线练习、学习记录管理等功能。

## 功能特性

- **用户系统**：注册、登录、密码找回、密码修改、个人信息管理
- **课程学习**：浏览课程列表、查看课程详情、视频播放、播放历史记录
- **在线练习**：练习题库浏览、练习详情答题
- **轮播广告**：首页 Banner 广告展示
- **本地存储**：使用 SQLite 数据库存储用户数据和播放历史

## 技术栈

| 类别 | 技术 |
|------|------|
| 开发语言 | Java |
| 最低 SDK | Android 9.0 (API 28) |
| 目标 SDK | Android 14 (API 34) |
| 构建工具 | Gradle 7.2 |
| AGP 版本 | 7.1.2 |

### 主要依赖

- **AndroidX** - AppCompat、ConstraintLayout、Material Design
- **Gson 2.10.1** - JSON 数据解析
- **OkHttp 4.9.0** - 网络请求
- **Glide 4.11.0** - 图片加载与缓存

## 项目结构

```
app/src/main/java/com/example/boxuegu/
├── activity/          # Activity 页面
│   ├── LoginActivity           # 登录
│   ├── RegisterActivity        # 注册
│   ├── FindPswActivity         # 找回密码
│   ├── ModifyPswActivity       # 修改密码
│   ├── MainActivity            # 主页面（底部导航）
│   ├── CourseDetailActivity    # 课程详情
│   ├── VideoPlayActivity       # 视频播放
│   ├── PlayHistoryActivity     # 播放历史
│   ├── ExercisesDetailActivity # 练习详情
│   ├── UserInfoActivity        # 个人信息
│   ├── ModifyUserInfoActivity  # 修改个人信息
│   ├── SettingActivity         # 设置
│   └── SplashActivity          # 启动页
├── adapter/           # RecyclerView 适配器
├── bean/              # 数据模型
├── fragment/          # Fragment 组件
├── sqlite/            # SQLite 数据库帮助类
├── utils/             # 工具类（常量、数据库操作、JSON解析、MD5加密等）
└── view/              # 自定义 View 组件
```

## 快速开始

### 环境要求

- Android Studio Arctic Fox 或更高版本
- JDK 8 或更高版本
- Android SDK 28+

### 构建运行

1. 克隆或下载本项目
2. 使用 Android Studio 打开项目根目录
3. 等待 Gradle 同步完成
4. 连接 Android 设备或启动模拟器
5. 点击 Run 按钮运行应用

```bash
# 或使用命令行构建
./gradlew assembleDebug
```

## 屏幕截图

> 可在此处添加应用截图

## 许可证

本项目仅供学习交流使用。
