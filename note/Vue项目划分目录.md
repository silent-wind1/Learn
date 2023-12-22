# Vue划分目录

```vue
src
	-assets // 存放静态资源
		-- img
		-- css
	-common // 公共方法
	-components //存放一些公共组件
		-common  // 存放一些完全公共的组件，不仅在这个项目能使用在写一个项目也能使用
		-content // 存放一些只能在这个项目的公共组件
	-network //存放网路请求
	-router // 路由
	-store // Vuex
	-views // 试图

```

