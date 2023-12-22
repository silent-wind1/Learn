





# Vue

## 1. 邂逅Vuejs

### 1.1 简单认识一下Vuejs

Vue是一个渐进式的框架，什么是渐进式呢？

- 渐进式意味着你可以将Vue作为应用的一部分嵌入其中，带来更丰富的交互体验
- 或者你希望将更多的业务逻辑使用Vue实现，那么Vue核心库以及其生态系统。
- 比如Core+Vue-router-Vuex，也可以满足你各种各样的需求。

Vue有很多特点和Web开发中常见的高级功能

- 解耦试图的数据
- 可复用的组件
- 前端路由技术
- 状态管理
- 虚拟Dom

这些特点，你不需要一个个去记住，我们在后面的学习和开发中都会慢慢体会到的

学习Vuejs的前提？

- 从零学习Vue，并不需要你具备其他类似与Angular、React，甚至JQuery的经验
- 但是你需要具备一定的HTML、CSS、JavaScript基础

### 1.2 安装Vuejs

安装Vue的方式有很多：

1. 直接CDN引入

   - CDN

     ```html
     对于制作原型或学习，你可以这样使用最新版本：
     <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
     对于生产环境，我们推荐链接到一个明确的版本号和构建文件，以避免新版本造成的不可预期的破坏：
     <script src="https://cdn.jsdelivr.net/npm/vue@2.6.12"></script>
     ```

     

   - 你可以选择引入开发环境版还是生成环境版本

     ```xml
     <!-- 开发环境版本，包含了有帮助的命令行警告 -->
     <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
     <!-- 生产环境版本，优化了尺寸和速度 -->
     <script src="https://cdn.jsdelivr.net/npm/vue"></script>
     ```

   - NPM安装

     后续通过webpack和CLI的使用，我们使用改方式

### 1.3. Hello Vuejs

我们来做一个Vue程序，体验一下Vue的响应式

我们来阅读JavaScript代码，会发现创建了一个Vue对象

创建Vue对象的时候，传入了一些options：{}

- {}中包含了el属性：该属性决定了这个Vue对象挂载到了哪一个元素上，很明显，我们这里挂载了id为app的元素上
- {}中包含了data属性：该属性中通常会存储一些数据
  - 这些数据可以是我们直接定义出来的，比如想上面这样。
  - 也可能来自网络，服务器加载的

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="app">{{messages}}</div>
<script src="../js/vue.js"></script>
<script>
    <!--  编程方式：声明式编程  -->
    let app = new Vue({
        el: '#app', // 用于挂载管理的元素
        data: {
            message: 'Hello Vue js！'
        }
    });
//    元素js的做法（编程方式：命令式编程）
//    1.创建div元素，设置id属性
//    2.定一个变量叫message
//    3.将message变量放在前面的div元素中显示
</script>
</body>
</html>
```

浏览器显示

![image-20210512220500740](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082114.png)

**什么是命令式编程和声明式编程：**

**命令式编程**：命令“机器”如何去做事情(how)，这样不管你想要的是什么(what)，它都会按照你的命令实现。

**声明式编程**：告诉“机器”你想要的是什么(what)，让机器想出如何去做(how)。

详细：https://www.cnblogs.com/sirkevin/p/8283110.html

### 1.4. 创建Vue实例传入的Options

你会发现，我们在创建Vue实例的时候，传入了一个对象options

详细请访问：https://cn.vuejs.org/v2/api/#%E9%80%89%E9%A1%B9-DOM

目前掌握这些选项：

- el：
  - **类型**：`string | Element`
  - **限制**：只在用 `new` 创建实例时生效。
  - **作用**：决定之后Vue实例会管理哪一个DOM
  - **详细**：https://cn.vuejs.org/v2/api/#el
- data：
  - **类型**：`Object | Function`
  - **限制**：组件的定义只接受 `function`。
- methods：
  - **类型**：`{ [key: string]: Function }`
  - **作用**：定义属于Vue的一些方法，可以在其他地方调用，也可以在指令中使用
  - **详细**：https://cn.vuejs.org/v2/api/#methods

### 1.5. Vue的生命周期

生命周期：事物从诞生到消亡的整个过程

vue每个组件都是独立的，每个组件都有一个属于它的生命周期，从一个组件**创建、数据初始化、挂载、更新、销毁**，这就是一个组件所谓的生命周期。在组件中具体的方法有:

  beforeCreate

  created

  beforeMount

  mounted

  (

​     beforeUpdate

​     updated

   )

  beforeDestroy

  destroyed

生命周期流程图：

![img](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524214404.webp)

详细：https://www.jianshu.com/p/410b6099be69

### 1.6 设置Vue的template（模板）

1. 打开Webstorm

   ![image-20210513133634369](https://i.loli.net/2021/05/18/gJRBiHmrXuZ6EDl.png)

2. 找到Editor-> Live Template - >Vue

   ![image-20210513133746863](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083438.png)

3. 进行设置 (Abbreviation: 缩写词， Description: 说明)

   ![image-20210513133835115](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083326.png)

   ```vue
   <div id="app">{{message}}</div>
   <script src="../js/vue.js"></script>
   <script>
     let app = new Vue({
       el: '#app', 
       data: {
         message: 'Hello Vue js！'
       }
     });
   </script>
   ```

4. 点击Change

   ![image-20210513134030331](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083640.png)

5. OK

## 2. 基本语法

### 2.1 插值操作

如何将data中的文件数据，插入到HTML中呢？

- 可以通过Mustache语法（也就是双大括号）
- Mustache：胡子/胡须

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <p>{{message}}</p>
  <p>{{firstName}} {{lastName}}</p>
  <p>{{firstName + lastName}}</p>

</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js!',
      firstName: '不能说的秘密',
      lastName: '周杰伦'
    }
  });
</script>
</body>
</html>
```



![image-20210513192402503](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524084232.png)

![image-20210513192018658](https://i.loli.net/2021/05/18/hFKcnid5WR2TbyP.png)

### 2.2 指令

####  v-once

在某些情况下，我们可能不希望界面随意的随意改变

- 这个时候，我们就可以使用Vue的指令

**v-once:**

- 改指令后面不需要跟如何表达式
- 该指令表达元素和其他组件只渲染一次，不会随着数据改变而改变

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <p v-once>{{message}}</p>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js!',
    }
  });
</script>
</body>
</html>
```



####  v-html

某些情况下，我们从服务器请求到的数据本身就是一个HTML代码

- 如果我们直接通过{{}}来输出，会将HTML代码也一起输出
- 但是我们可能希望的是按照HTML进行解析，并且显示对应的数据内容

如果我们希望解析出HTML展示可以使用v-html指令

- 该指令后面往往会将跟上一个string类型
- 会将string的html解析出来并且进行渲染

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <p v-once>{{message}}</p>
  <p>{{url}}</p>
    // 使用v-html进行渲染
  <p v-html="url"></p>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js!',
      url: '<a href="https://cn.vuejs.org/v2/guide/">官网</a>'
    }
  });
</script>
</body>
</html>
```

![image-20210513193725507](https://i.loli.net/2021/05/18/Hf6OU7wFxBCRSt4.png)

####  v-text

####  v-pre

####  v-cloak(cloak：斗篷)



## 3. 绑定属性

### 3.1 v-bind

某些属性我们也希望动态来绑定。

- 比如动态绑定a元素的href属性
- 比如动态绑定img元素的src属性

这个时候，我们可以使用v-bind指令：

- 作用：动态绑定属性
- 缩写：：
- 预期： any fwith argument）I Object（without argument）
- 参数：attrOrProp（optional）

我们如果直接使用musttache语法进行绑定的话，会出现下面的情况

![image-20210513195244662](https://i.loli.net/2021/05/18/geYLcyfH89MIQBN.png)



![image-20210513195412087](https://i.loli.net/2021/05/18/e3zdLEqNBuXYMA4.png)

正确的使用方式是通过v-bind，让标签进行进行动态绑定达到我们想要的效果

![image-20210513200212672](https://i.loli.net/2021/05/18/7h3kGgNJFWKULaA.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 错误的做法：这里不能使用mustache语法 -->
<!--  <img src="{{img}}" alt="">-->
  <!-- 正确的使用方式 -->
  <img v-bind:src="img" alt=""><br>
  <a v-bind:href="href">哔哩哔哩</a>
<!-- 语法糖使用方式 -->
  <a :href="href"></a>
  <img :src="img" alt="">
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      img: "https://cn.vuejs.org/images/logo.png",
      href: "https://www.bilibili.com/"
    }
  });
</script>
</body>
</html>
```

#### 动态绑定class

当然我们也可以使用v-bind进行动态绑定class

![image-20210513201902662](https://i.loli.net/2021/05/18/eyAzG7gI12xcid5.png)

效果：

![image-20210513201951496](https://i.loli.net/2021/05/18/YrJgaRUHwpb3Cz4.png)

通过console来更改Boolean值

![image-20210513202005639](https://i.loli.net/2021/05/18/dU2D6lWRXTA8VOp.png)



上面那种写法会让人感觉到不是很友好，我们可以使用函数来封装

![image-20210513203120591](https://i.loli.net/2021/05/18/bSE9lqw8VWUyP1x.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <style>
    .active{
        color: skyblue;
    }
  </style>
</head>
<body>
<div id="app">
  <!--
      {}表示是一个对象
      {key1: value1, key2: value2}
      {类名1：boolean, 类型2: boolean}
   -->
  <!-- 两个标量都为true时，样式才会生效 -->
  <h2 v-bind:class="{active: isActive, line: isLine}">{{message}}</h2>
  <!-- 上面那种写法会让人感觉到不是很友好，我们可以使用函数来封装 -->
  <h2 v-bind:class="">{{message}}</h2>
  <!-- 使用v-on指令进行动态绑定事件，后面我们会学习到 -->
  <button v-on:click="btnClick">按钮</button>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      isActive: true,
      isLine: true
    },

    methods: {
      btnClick: function(){
        this.isActive = !this.isActive
      },
      getClass: function() {
        return {active: this.isActive, line: this.isLine}
      }

    }
  });
</script>
</body>
</html>
```



![image-20210513204809830](https://i.loli.net/2021/05/18/hPSWy2nl6UeZspN.png)







#### 动态绑定style

在写CSS属性的时候，比如font-size

- 我们可以使用驼峰式
- 或者短横线分隔font-size（但是记得加单引号括起来)

实例图：

![image-20210513204918506](https://i.loli.net/2021/05/18/qPlEHiZb2G3onTm.png)

效果图：

![image-20210513204937059](https://i.loli.net/2021/05/18/dBfoGHnPgwqTjkl.png)

也可以使用变量名来进行

![image-20210513205336218](https://i.loli.net/2021/05/18/x6nXmlGWDLEzrCJ.png)

效果图：

![image-20210513205358168](https://i.loli.net/2021/05/18/mUlCIP2ERYudBtq.png)

代码：

````html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
<!--  <h2 :style="{key(属性名): value(属性值)}"></h2>-->
  <!-- 50px必须加单引号， 否则当做一个变量去解析 -->
  <h2 :style="{fontSize: '50px'}">{{message}}</h2>
  <!-- 使用font-size必须加单引号 -->
  <h2 :style="{'fontSize': '50px'}">{{message}}</h2>
  <!-- finalSize当成一个变量使用 -->
  <h2 :style="{fontSize: finalSize + 'px'}">{{message}}</h2>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      finalSize: 100
    }
  });
</script>
</body>
</html>
````

### 3.2 计算属性

**基本使用**：

我们知道，在模板中可以直接通过插值语法显示一些data中的数据。

但是在某些情况，我们可能需要对数据进行一些转化后再显示，或者需要将多个数据结合起来进行显示

- 比如我们有firstName和lastName两个变量，我们需要显示完整的名称。

- 但是如果多个地方都需要显示完整的名称，我们就需要写多个{firstName} {lastName}

基本使用：

![image-20210513211216765](https://i.loli.net/2021/05/18/SB3PTk9OViocGfR.png)

效果图：

![image-20210513211228456](https://i.loli.net/2021/05/18/X514x8aqIBT6KVD.png)

复杂操作：

![image-20210513212220412](https://i.loli.net/2021/05/18/r4ITnJLEmUPGXQy.png)

结果：

![image-20210513212247646](https://i.loli.net/2021/05/18/QK4ulHb8oZsCV9I.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  {{totalPrice}}
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      books:[
        {id:110, name: 'Java', price: 100},
        {id:111, name: 'Python', price: 100},
        {id:112, name: 'Vue', price: 100},
        {id:113, name: 'C', price: 100},
      ]
    },
    // computed: 计算机属性()
    computed:{
      totalPrice: function (){
        let result = 0
        for (let i = 0; i < this.books.length; i++) {
           result += this.books[i].price;
        }
        return resultA
        // 这两种是es6语法当中的
      //   for (let i in this.books) {
      //     result += this.books[i].price
      //   }
      //   for (let book of this.books) {
      //     result += book.price
      //   }
      }
    }
  });
</script>
</body>
</html>
```



### 3.3 computed和methods的对比

你可能已经注意到我们可以通过在表达式中调用方法来达到同样的效果：

```js
<p>Reversed message: "{{ reversedMessage() }}"</p>
// 在组件中
methods: {
  reversedMessage: function () {
    return this.message.split('').reverse().join('')
  }
}
```



我们可以将同一函数定义为一个方法而不是一个计算属性。两种方式的最终结果确实是完全相同的。然而，不同的是**计算属性是基于它们的响应式依赖进行缓存的**。只在相关响应式依赖发生改变时它们才会重新求值。这就意味着只要 `message` 还没有发生改变，多次访问 `reversedMessage` 计算属性会立即返回之前的计算结果，而不必再次执行函数。

这也同样意味着下面的计算属性将不再更新，因为 `Date.now()` 不是响应式依赖：

```js
computed: {
  now: function () {
    return Date.now()
  }
}
```

相比之下，每当触发重新渲染时，调用方法将**总会**再次执行函数。

我们为什么需要缓存？假设我们有一个性能开销比较大的计算属性 **A**，它需要遍历一个巨大的数组并做大量的计算。然后我们可能有其他的计算属性依赖于 **A**。如果没有缓存，我们将不可避免的多次执行 **A** 的 getter！如果你不希望有缓存，请用方法来替代。

**总结：**

computed：会进行缓存，如果多次使用时，计算属性只会调用一次。

methods: 调用一次执行一次





### 3.4 v-on

概述：
在前端开发中，我们需要经常和用于交互。

- 这个时候，我们就必须监听用户发生的时间，比如击、拖拽、键盘事件等等
- 在Vue中如何监听事件呢？使用v-on指令v-on介绍

v-on介绍：

- 作用：绑定事件监听器
- 缩写：@
- 预期：Function |Inline Statement|Object
- 参数：event

基本使用

![image-20210514152517666](https://i.loli.net/2021/05/18/vnrzSBpY9wiD4oL.png)

上面这种方法，适合简单的事件绑定，如果我们有其他的功能实现这种写法就不太好，所以我推荐下面这种写法

![image-20210514152900191](https://i.loli.net/2021/05/18/OiXKWDbLM7ScQ85.png)

当然，也可以用语法糖的方式进行编写

![image-20210514152957124](https://i.loli.net/2021/05/18/Os3GVSLKWFoandY.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <h2>{{number}}</h2>
  <!-- 简单的使用 click：鼠标点击事件 -->
<!--  <button v-on:click="number++">+</button>-->
<!--  <button v-on:click="number&#45;&#45;">-</button>-->
<!--  <button v-on:click="increment">+</button>-->
<!--  <button v-on:click="decrement">-</button>-->
  <button @:click="increment">+</button>
  <button @:click="decrement">-</button>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      number: 10 // 定义一个参数
    },
    methods:{
      increment() {
        this.number++
      },
      decrement() {
        this.number--
      }
    }
  });
</script>
</body>
</html>

```

v-on还可以进行传参数

![image-20210514154932579](https://i.loli.net/2021/05/18/mcd9Q4gP5XIhFxq.png)

如果你需要传递参数就记得添加（），如果你不需要传递参数就不用添加（）

![image-20210514155154847](https://i.loli.net/2021/05/18/z5FhKcOWtyIkjfA.png)

如果不知道什么是MouseEvent对象的话：

https://blog.csdn.net/claroja/article/details/103990202

代码：

````html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 传递参数 -->
  <button @click="btnClick(123)">按钮1</button>
<!-- 如果方法定义了一个参数，我们这里不传递参数的话，它会传递一个MouseEvent对象 -->
  <button @click="btnClick">按钮2</button>
  <!-- 我们这里加了括号没有传递参数的话，形参就是undefined-->
  <button @click="btnClick()">按钮3</button>

</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    methods: {
      btnClick(name) {
        console.log(name)
      }
    }
  });
</script>
</body>
</html>
````



v-on的修饰符：

- .stop - 调用event.stopPropagation()
- .prevent - 调用event.preventDefault()
- .{keyCode | keyAlias} 只当时间是从特定键触发时才触发回调
- .native - 监听组件根元素的原生事件
- .once - 只触发一次回调

基本使用：

![image-20210514161424397](https://i.loli.net/2021/05/18/Q1ryJE2NxMvKb3z.png)

效果图：

![image-20210514161509466](https://i.loli.net/2021/05/18/zti4lD9evfk3JUV.png)

如果我们想组织这种冒泡事件可以使用.stop

![image-20210514161611243](https://i.loli.net/2021/05/18/zDGhsgjctu6WaJC.png)

效果图：

![image-20210514161621844](https://i.loli.net/2021/05/18/93F5SeTMg1nEzwA.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <div @click="divClick">
    aaa
    <!--  当我们点击这个按钮时，它会出现冒泡事件  -->
    <button @click.stop="btnClick">按钮</button>
  </div>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    methods: {
      btnClick() {
        console.log("btnClick")
      },
      divClick() {
        console.log("divClick")
      }
    }
  });
</script>
</body>
</html>
```





## 4. 条件判断

### 4.1 v-if   v-else-if  v-else

 v-if 指令用于条件性地渲染一块内容。这块内容只会在指令的表达式返回true 值的时候被渲染。

基本使用：

![image-20210514162527417](https://i.loli.net/2021/05/18/lZfqLp6ojNhBzyK.png)

效果图：

![image-20210514162855046](https://i.loli.net/2021/05/18/U3Du7yPBw6Avnxg.png)

![image-20210514162913593](https://i.loli.net/2021/05/18/fpbIn6WD4aMXvkB.png)

v-else的使用

![image-20210514163151073](https://i.loli.net/2021/05/18/Ss7Dqieo9nxAE25.png)

效果图：

![image-20210514163202247](https://i.loli.net/2021/05/18/Pm8pIG3fJE9g52d.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <h1 v-if="isShow">{{message}}</h1>
  <h1 v-else>isShow为false的时候你才能看到我</h1>
  <button @click="isShow_function">按钮</button>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      isShow: true
    },
    methods: {
      isShow_function() {
        this.isShow = !this.isShow
        console.log(this.isShow)
      }
    }
  });
</script>
</body>
</html>
```

### 4.2 v-show

v-show和v-if非常相似，也用于决定一个元素是否渲染

v-if和v-show对比

- v-if和v-show都可以决定一个元素是否渲染，那么开发中我们如何选择？

  - v-if当条件为false时，压根不会有对应的元素在DOM中
  - v-show当条件为false时，仅仅是将元素的display属性设置为none而已

- 开发中如何选择？

  - 当需要在显示与隐藏之间切片很频繁时，使用v-show
  - 但只有一次切换时，使用v-if

  

  基本使用：

  ![image-20210514164411046](https://i.loli.net/2021/05/18/Xi4v58MPTAHEJr6.png)

效果图：

![image-20210514164425942](https://i.loli.net/2021/05/18/7PEybMp1oZKzqIx.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- v-if当条件为false时，压根不会有对应的元素在DOM中 -->
  <p v-if="isShow">{{message}} v-if</p>
  <!-- v-show为false时，仅仅是将元素的display属性设置为none而已 -->
  <p v-show="isShow">{{message}} v-show</p>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      isShow: true
    }
  });
</script>
</body>
</html>
```





## 5. 循环遍历

### 5.1 v-for

当我们有一组数据需要渲染时，我们就可以使用v-for

- v-for的语法类似于JavaScript中的for循环
- 格式：item in itmes的形式

如果在遍历的过程中，我们需要拿到元素在数组的中的索引值

- 语法格式： v-for = (item, index) in items
- 其中的index就代表了取出的item在原数组中的索引值



基本使用：

![image-20210514165328625](https://i.loli.net/2021/05/18/GQvtmZ9Ihe1SXpM.png)

效果图：

![image-20210514165339356](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524092048.png)

当然也可以遍历对象

![image-20210514165820453](https://i.loli.net/2021/05/18/iqj1Mbc4hwrfQUT.png)

效果图：

![image-20210514165832190](https://i.loli.net/2021/05/18/MTyFEq8eNHzDOjw.png)

如果想拿到key的话，可以这样：

![image-20210514170030270](https://i.loli.net/2021/05/18/vpDL4cQN2oGsI7e.png)

效果图：

![image-20210514170038110](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524085919.png)

**注意：**遍历数组拿下标，item在前，index在后， 遍历对象拿key的话， values在前， key在后



## 6.表单绑定

### 6.1 v-model

Vue中使用v-model指令来实现表单元素和数据的双向绑定

![image-20210514205554777](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524090127.png)

效果图：



![image-20210514205604277](https://i.loli.net/2021/05/18/ErndWy8IYsAv4fF.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <input type="text" v-model="message">
  {{message}}
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
</body>
</html>
```



v-model其实是一个语法糖，他的背后本质上是包含两个操作：

- v-bind绑定一个value属性
- v-on指令给当前元素绑定input事件

![image-20210514205927500](https://i.loli.net/2021/05/18/CR8Z1qI5LXsvNjm.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <input type="text" v-bind:value="message" v-on:input="message=$event.target.value">
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
</body>
</html>
```



我们可以使用v-model结合radio使用：

![image-20210514210438944](https://i.loli.net/2021/05/18/ZuwI3X95jhvfWya.png)

效果图：

![image-20210514210450467](https://i.loli.net/2021/05/18/POlKX1c8F3tMBQA.png)

也可以配合checkbox：

![image-20210514210933800](https://i.loli.net/2021/05/18/2fNWQ6z7BhDmaXr.png)

效果图：

![image-20210514210949517](https://i.loli.net/2021/05/18/kjErTvRKZbn38IC.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <input type="checkbox" value="LXL" v-model="hobbies">LXL
  <input type="checkbox" value="LOL" v-model="hobbies">LOL
  <input type="checkbox" value="LkL" v-model="hobbies">LKL
  <input type="checkbox" value="LPL" v-model="hobbies">LPL
  <br>
  <h2>你的爱好：{{hobbies}}</h2>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      hobbies: []
    }
  });
</script>
</body>
</html>
```



### 6.2 值绑定

值绑定的意思就是给value赋值

- 我们前面的value中的值，可以回头看一下，都是在定义input的时候直接给定的
- 但是真实开发中，这些input的值可能是从网络获取或定义data中的
- 所以我们可以通过v-bind:value动态给value绑定值

![image-20210514212235158](https://i.loli.net/2021/05/18/nQONVFs4xCb2gv1.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <input type="checkbox" value="LXL" v-model="hobbies">LXL
  <input type="checkbox" value="LOL" v-model="hobbies">LOL
  <input type="checkbox" value="LkL" v-model="hobbies">LKL
  <input type="checkbox" value="LPL" v-model="hobbies">LPL
  <br>
  <h2>你的爱好：{{hobbies}}</h2>
<!-- 我们通过v-for循环遍历my_hobbies并且生成input标签 在通过v-bind绑定值 -->
  <label v-for="item in my_hobbies" :for="item">
    <!--  我们在通过v-bind绑定item所遍历的值， 在通过v-model进行双向绑定  -->
    <input type="checkbox" :value="item" v-model="hobbies">{{item}}
  </label>
</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      hobbies: [],
      my_hobbies: ['LXL', 'LOL', 'LKL', 'LPL']
    }
  });
</script>
</body>
</html>
```



### 6.3 修饰符

lazy修饰符：

- lazy修饰符可以让数据在失去焦点或者回车时才会更新

number修饰符：

- number修饰符可以让在输入框中输入的内容自动转成数字类型

trim修饰符：

- trim修饰符可以过滤内容左右两边的空格



## 7. 组件化开发

### 7.1 什么是组件化？

人面对复杂问题的处理方式：

- 任何一个人处理信息的逻辑能力都是有限的
- 所以，当面对一个非常复杂的问题时，我们不太可能一次性搞定一大堆的内容。
- 但是，我们人有一种天生的能力，就是将问题进行拆解。
- 如果将一个复杂的问题，拆分成很多个可以处理的小问题，再将其放在整体当中，你会发现大的问题也会迎刃而解。

组件化也是类似的思想：

- 如果我们将一个页面中所有的处理逻辑全部放在一起，处理起来就会变得非常复杂，而且不利于后续的管理以及扩展。
- 但如果，我们讲一个页面拆分成一个个小的功能块，每个功能块完成属于自己这部分独立的功能，那么之后整个页面的管理和维护就变得非常容易了。

![image-20210514213558620](https://i.loli.net/2021/05/18/C6r7NxRTIA85wyV.png)

### 7.2 Vue组件化思想

组件化是Vue.js中的重要思想

- 他提供了一中抽象，让我们可以开发出一个个独立可复用的小组件来构造我们的应用

- 任何的应用都会被抽象成一颗组件树

  ![Component Tree](https://cn.vuejs.org/images/components.png)

组件化思想的应用：

- 有了组件化的思想，我们在之后的开发中就要充分的利用它
- 尽可能的将页面拆分成一个个小的、可复用的组件
- 这样让我们的代码更加方便组织和管理，并且扩展性也更强



### 7.3 组件化的基本步骤

1. 创建组件构造器

   Vue.extend0：

   - 调用Vue.extend0创建的是一个组件构造器。
   - 通常在创建组件构造器时，传入template代表我们自定义组件的模板。
   - 该模板就是在使用到组件的地方，要显示的HTML代码。
   - 事实上，这种写法在Vue2.x的文档中几乎已经看不到了，它会直接使用下面我们会讲到的语法糖，但是在很多资料还是会提到这种方式，而且这种方式是学习后面方式的基础。

2. 注册组件

   Vue.component（）：

   - 调用Vue.component0是将刚才的组件构造器注册为一个组件，并且给它起一个组件的标签名称。

   - 所以需要传递两个参数：1、注册组件的标签名 2、组件构造器

3. 使用组件

   - 组件必须挂载在某个Vue实例下，否则它不会生效。

   

![image-20210514214218082](https://i.loli.net/2021/05/18/qhtWoXJH2dNY9Vc.png)

![image-20210514221232821](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082324.png)

效果图：

![image-20210514221245174](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082327.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
<!-- 使用组件 -->
  <my-cpn></my-cpn>
</div>
<script src="../js/vue.js"></script>
<script>
<!-- 1.创建组件构造器对象 -->
  const cpnC = Vue.extend({
    template: `
    <div>
      <h2>我是标题</h2>
      <p>我是内容1</p>
      <p>我是内容2</p>
    </div>
    `
  })
  // 2. 注册组件
  Vue.component('my-cpn', cpnC)
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
</body>
</html>
```



### 7.4 全局组件和局部组件

我们上面创建的就是全局组件，全局组件就是可以在多个Vue实例里面使用

![image-20210515104805783](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082333.png)

效果图：

<img src="https://i.loli.net/2021/05/18/vAGoW83lQYSZnCd.png" alt="image-20210515104918977"  />

那么我们如何创建局部组件? 其实创建局部组件也很简单，把要注册的组件放到某个Vue实例里面注册就好了

![image-20210515105554781](https://i.loli.net/2021/05/18/lHTpxJoUQuWBica.png)

效果图：

![image-20210515105614009](https://i.loli.net/2021/05/18/zd9nXvDQ5TAgekW.png)

我们会发现<cpn>标签只在<div id="app">里面有效，这就是局部组件

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn></cpn>
  <cpn></cpn>
</div>

<div id="app1">
  <cpn></cpn>
</div>
<script src="../js/vue.js"></script>
<script>
  <!-- 1.创建组件构造器对象 -->
  const cpnC = Vue.extend({
    template: `
    <div>
      <h2>我是标题</h2>
      <p>我是内容1</p>
      <p>我是内容2</p>
    </div>
    `
  })
  // 注册组件(意味着可以在多个Vue实例中使用)
  // Vue.component("my-cpn", cpnC)

  // 如何注册局部组件？
  // 我们只需要在某个Vue实例里面注册即可
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    // components：组件，component的复数，表示可以使用多次
    components: {
      // cpn:使用组件的标签名
      cpn: cpnC
    }
  });
  // 创建一个vue实例
  let app1 = new Vue({
    el: '#app1'
  })
</script>
</body>
</html>
```



### 7.5 父组件和子组件

什么是父组件，什么又是子组件。简单来说：我们把某段代码封装成了一个组件，而这个段组件里面又引入另一个组件，我们把**引入封装**的组件叫做**父组件**，把**被引入**的组件叫做**子组件**。

![image-20210515112959373](https://i.loli.net/2021/05/18/RXuvPcUjiD8wa5o.png)

效果图：

![image-20210515113026145](https://i.loli.net/2021/05/18/8wHyk74ARnWSQNc.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn></cpn>
</div>
<script src="../js/vue.js"></script>
<script>
<!-- 注册子组件 -->
  const cpnC2 = Vue.extend({
    template: `
     <div>
      <h2>我是子组件</h2>
      <p>我是子组件的内容</p>
    </div>
    `
  })
  // 注册父组件
  const cpnC1 = Vue.extend({
    template: `
    <div>
      <h2>我是父组件</h2>
      <p>我是父组件的内容</p>
<!--  // 但解析到这一步的时候，它会先去你Vue实例components里面找你是否注册了cpn2-->
<!--  // 如果没有找到他才会在cpnC1components去找-->
      <cpn2></cpn2>
    </div>
    `,
    // 把子组件注册到父组件
    components: {
      cpn2: cpnC2
    },
  })
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    components: {
      cpn: cpnC1
    }
  });
</script>
</body>
</html>
```





### 7.6 注册组件的语法糖方式

我们之前注册组件的方式，会觉得有些繁琐

- Vue为了简化这个过程，提供了注册的语法糖
- 主要是省去了调佣Vue.extend()的步骤，而是可以直接使用一个对象来替换

![image-20210515114939573](https://i.loli.net/2021/05/18/l6oqWKkE3z25GjO.png)

效果图：

![image-20210515114949705](https://i.loli.net/2021/05/18/Ua5Tzu4pX8ymKbF.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 使用组件 -->
  <cpn></cpn>
</div>
<script src="../js/vue.js"></script>
<script>
  // component会跳用Vue.extend来创建组件
  // 所以我们以后可以使用这种语法糖模式来创建全局组件
  Vue.component('my-cpn', {
    template: `
    <div>
      <h2>组件</h2>
      <p>组件的内容</p>
    </div>
    `
  })
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    //  局部组件
    components: {
      cpn:{
        template: `
        <div>
          <h2>组件</h2>
          <p>组件的内容</p>
        </div>
    `
      }
    }
  });
</script>
</body>
</html>
```



### 7.7 组件模板抽离

我们之前虽然简化了Vue组件的注册过程，另外还有一个地方的写法比较麻烦，就是template模板的写法

如果我们能将其中的html分离出来写，然后挂载到对应的组件上，必然结构会变得非常清晰

Vue提供了两种方案来定义HTML模块内容：

- 使用<srcipt>标签
- 使用<template>标签 (推荐使用这种方法）

使用srcipt标签：

![image-20210515120341664](https://i.loli.net/2021/05/18/2dlVyZ9FXTGH1kD.png)

使用template标签：

**![image-20210515120636534](https://i.loli.net/2021/05/18/G8tHoWTMcgN2dmk.png)**

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 使用组件 -->
  <my-cpn></my-cpn>
</div>
<!--使用template标签进行模板分离-->
<template id="cpn1">
  <div>
    <h2>组件标题</h2>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  // 2. 注册组件
  Vue.component('my-cpn', {
    template: "#cpn1"
  })
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
</body>
</html>
```

### 7.8  Vue组件中的data为什么必须是一个函数

Vue组件中data为什么必须是一个函数呢？

从之前的Vue实例里面我们可以看出来，data是一个对象

```html
<div id="app">

</div>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app', 
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
```



当我们使用组件开发的时候，如果data不是个函数，是个对象的话，会出现一种情况，连锁反应，我们用下面的代码来举个例子

```html
<script>
  Vue.component('cpn', {
    template: '#cpn1',
    data: {
      number: 0
    },
    methods: {
      increment() {
        this.number++
      },
      decrement(){
        this.number--
      }
    }
  })
</script>
```



![image-20210515125412844](https://i.loli.net/2021/05/18/vBOyHGcte36D9Ym.png)

如果我们直接这样写的法，Vue会给我们直接报错，所以这种方式没法演示，我将采取另外一种方式，来演示

![image-20210515125503998](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082411.png)

![image-20210515125530170](https://i.loli.net/2021/05/18/BEwu4l1fthNd5PS.png)

但我们点击其中某一个按钮的时候，会发现所以的数量都发生了变化。

为什么会出现这种情况呢？

因为Object是引用数据类型，如果不用function返回，每个组件的data都是内存的同一个地址，一个数据改变了其他也改变了；

JavaScript只有函数构成作用域(注意理解作用域，**只有函数{}构成作用域**,对象的{}以及if(){}都不构成作用域),data是一个函数时，每个组件实例都有自己的作用域，每个实例相互独立，不会相互影响。

![image-20210515130104576](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082420.png)

效果图：

![image-20210515130115489](https://i.loli.net/2021/05/18/yfeX5Rx2MbwT6hd.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn></cpn>
  <cpn></cpn>
  <cpn></cpn>
</div>
<template id="cpn1">
  <div>
    <h2>当前计数：{{number}}</h2>
    <button @click="increment">+</button>
    <button @click="decrement">-</button>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  Vue.component('cpn', {
    template: '#cpn1',
    data() {
      return {
        number: 0
      }
    },
    methods: {
      increment() {
        this.number++
      },
      decrement(){
        this.number--
      }
    }
  })
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    }
  });
</script>
</body>
</html>
```



### 7.9 父子组件通信

我们提到了子组件是不能引用父组件或者Vue实例的数据的。

但是，在开发中，往往一些数据确实需要从上层传递到下层∶

- 比如在一个页面中，我们从服务器请求到了很多的数据。
- 其中一部分数据，并非是我们整个页面的大组件来展示的，而是需要下面的子组件进行展示.
- 这个时候，并不会让子组件再次发送一个网络请求，而是直接让大组件(父组件)将数据传递给小组件(子组件)

如何进行父子组件间的通信呢?Vue官方提到

- 通过props向子组件传递数据
- 通过事件向父组件发送消息

![image-20210515152002996](https://i.loli.net/2021/05/18/tyYkvno7dEP5ubJ.png)

#### 7.9.1 props基本用法

在组件中，使用选项props来声明需要从父级接收到的数据。

props的值有两种方式:

- 方式一︰字符串数组，数组中的字符串就是传递时的名称。
- 方式二∶对象，对象可以设置传递时的类型，也可以设置默认值等。

使用数组的方式进行传递：

![image-20210515160810126](https://i.loli.net/2021/05/18/E5STt1I83PlsZ9m.png)

效果图：

![image-20210515160822029](https://i.loli.net/2021/05/18/CXk6r2xpYhwGtcn.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn :cmessage="message" :cmovies="movies"></cpn>
</div>
<template id="cpn">
  <div>
    <p>{{cmessage}}</p>
    <ul>
      <li v-for="item in cmovies">{{item}}</li>
    </ul>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
<!-- 父传子：props -->
  const cpn = {
    template: '#cpn',
    // 可以通过数组的方式进行传递
    // 数组里面的数据，不是字符串，而是一个变量名
    props:['cmessage', 'cmovies']
  }
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      movies: ['不能说的秘密', 'LXY', 'YXL']
    },
    // 注册组件
    components: {
      cpn  // 注册模板
    }
  });
</script>
</body>
</html>
```



通过数组的传递方式，我们会感觉到有点变扭，数组里面的数据看起来明明是字符串，为什么会是数组呢

所以我们一般使用用对象的方式传递

![image-20210515161545936](https://i.loli.net/2021/05/18/LM4tUQc1EwiTK9A.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 这里必须使用v-bind 不然cmessage表示一个变量，
   就会把message当初一个字符串赋值给cmessage -->
  <cpn :cmessage="message" :cmovies="movies"></cpn>
</div>
<template id="cpn">
  <div>
    <p>{{cmessage}}</p>
    <ul>
      <li v-for="item in cmovies">{{item}}</li>
    </ul>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
<!-- 父传子：props -->
  const cpn = {
    template: '#cpn',
    // 可以通过数组的方式进行传递
    // 数组里面的数据，不是字符串，而是一个变量名
    props: {
      cmessage: {
        type: String, // 类型限制
        default: 'aaa', // 设置默认值
        required: true // required：必须的， 这个参数必须要传，不传就会报错
      },
      cmovies: {
        type: Array,
        default: []
      }
    }
  }
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      movies: ['不能说的秘密', 'LXY', 'YXL']
    },
    // 注册组件
    components: {
      cpn  // 注册模板
    }
  });
</script>
</body>
</html>
```

#### 7.9.2 props驼峰标识

html代码有一个缺陷，就是不区别大小写，所以当我们使用驼峰命名发的时候，会出现这种问题

![image-20210515163252949](https://i.loli.net/2021/05/18/vcYZ5eQfEFOBU8a.png)



效果图：

![image-20210515163302335](https://i.loli.net/2021/05/18/GptwynWksATNFIg.png)

如果我们要是用驼峰标识的话，需要这样写

![image-20210515163504430](https://i.loli.net/2021/05/18/tqMLecGHhFNmRSp.png)

效果：

![image-20210515163513819](https://i.loli.net/2021/05/18/lCWzr5pkYsi9udj.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <!-- 因为HTML代码不区分大小写，如果我们要使用驼峰标识需要写成这样c-message -->
  <cpn :c-message="message" :c-movies="movies"></cpn>
</div>
<template id="cpn">
  <div>
    <p>{{cMessage}}</p>
    <ul>
      <li v-for="item in cMovies">{{item}}</li>
    </ul>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  <!-- 父传子：props -->
  const cpn = {
    template: '#cpn',
    props: {
      cMessage: String,
      cMovies: Array
    }
  }
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！',
      movies: ['不能说的秘密', 'LXY', 'YXL']
    },
    // 注册组件
    components: {
      cpn  // 注册模板
    }
  });
</script>
</body>
</html>
```



### 7.10 子传父通信（自定义事件）

子组件向父组件传递数据时，使用自定义事件实现

**自定义事件的流程：**

> - 在子组件中，通过$emit()来监听事件
> - 在父组件中，通过v-on来监听子组件事件

![image-20210515170520059](https://i.loli.net/2021/05/18/81sUNwg39mBr4yh.png)

![image-20210515170528034](https://i.loli.net/2021/05/18/whOY968ixIGproq.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<!--父组件模板-->
<div id="app">
  <cpn @item-click="cpnClick"></cpn>
</div>
<!--子组件模板-->
<template id="cpn">
  <div>
    <!--  这里循环遍历并且绑定点击事件  -->
    <button v-for="item in categories" @click="btnClick(item)">{{item.name}}</button>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  <!-- 子组件 -->
  const cpn = {
    template: '#cpn',
    data(){
      return{
        categories:[
          {id: 111, name: 'LXY', age:18},
          {id: 222, name: 'YXL', age:18},
          {id: 333, name: 'YF', age:18}
        ]
      }
    },
    methods: {
      btnClick(item) {
        // emit: 发出，射出; 发出事件： 自定义事件
        // 通过点击事件，把item对象传给父组件
        // this.$emit('自定义的事件名称'，传送参数）
        this.$emit('item-click', item)

      }
    }
  }
  // 父组件
  let app = new Vue({
    el: '#app',
    methods: {
      // 父组件设置一个方法，获取到子组件传递过来的对象
      cpnClick(item) {
        console.log(item)
      }
    },
    // 注册组件
    components: {
      cpn  // 注册模板
    }
  });
</script>
</body>
</html>
```

小结：

props用于父组件向子组件传递数据，还有一种比较常见的是子组件传递数据或事件到父组件中

我们应该如何处理呢?这个时候，我们需要使用自定义事件来完成。
什么时候需要自定义事件呢?

- 当子组件需要向父组件传递数据时，就要用到自定义事件了。

我们之前学习的v-on不仅仅可以用于监听DOM事件，也可以用于组件间的自定义事件。自定义事件的流程︰

- 在子组件中，通过$emit()来触发事件。
- 在父组件中，通过v-on来监听子组件事件。

我们来看一个简单的例子︰

- 我们之前做过一个两个按钮+1和-1，点击后修改couRter。
- 我们整个操作的过程还是在子组件中完成，但是之后的展示交给父组件。
- 这样，我们就需要将子组件中的counter，传给父组件的某个属性，比如total。



### 7. 11 父子组件的访问方式

有时候我们需要父组件直接访问子组件，子组件直接访问父组件，或者是子组件访问跟组件。

- 父组件访问子组件∶使用**$children**或**$refs** reference(引用)
- 子组件访问父组件:使用$parent

我们先来看下$children的访问

- this.$children是一个数组类型，它包含所有子组件对象。
- 我们这里通过一个遍历，取出所有子组件的message状态。

![image-20210515184353599](https://i.loli.net/2021/05/18/Epk7aVgBRANSuMY.png)

效果图：

![image-20210515184415904](https://i.loli.net/2021/05/18/SxNHhqycunOZg1A.png)

通过上述图我们发现，$children去子组件返回了一个Vuecomponent对象

里面有很多不是我们想要的数据，所以我们一般不推荐使用$children，我们一般推荐使用**$refs**

![image-20210515184905291](https://i.loli.net/2021/05/18/596JEdlFrQsTSUv.png)

效果图：

![image-20210515184916127](https://i.loli.net/2021/05/18/6igyw24xGP8kOjv.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<!--父组件-->
<div id="app">
  <cpn ref="aaa"></cpn>
  <!-- 通过点击事件去template获取数据 -->
  <button @click="btnClick">按钮</button>
</div>
<!--子组件-->
<template id="cpn">
  <div>
    <div>我是子组件</div>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    methods: {
      btnClick() {
      //  1.通过$children去子组件中拿到数据
      //   console.log(this.$children)
      //   console.log(this.$children[0].name)
      //  2. $refs
        console.log(this.$refs.aaa.name)
      }
    },
    components: {
      cpn: {
        template: '#cpn',
        data() {
          return {
            name: "我的名字叫做子组件"
          }
        }
      }
    }
  });
</script>
</body>
</html>
```



### 7.12 slot

为什么要使用slot（插槽）？

- 在生活中很多地方都有插槽，电脑的USB插槽，插板当中的电源插槽
- 插槽的目的是让我们原来的设备具备更多的扩展性。
- 比如电脑的USB我们可以插入U盘、硬盘、手机、音响、键盘、鼠标等等。

组件的插槽∶

- 组件的插槽也是为了让我们封装的组件更加具有扩展性。
- 让使用者可以决定组件内部的一些内容到底展示什么。

例子︰移动网站中的导航栏

- 移动开发中，几乎每个页面都有导航栏。
- 导航栏我们必然会封装成一个插件，比如nav-bar组件。
- 一旦有了这个组件，我们就可以在多个页面中复用了。

如何去封装这类的组件呢?

- 它们也很多区别，但是也有很多共性。
- 如果，我们每一个单独去封装一个组件，显然不合适︰比如每个页面都返回，这部分内容我们就要重复去封装。
- 但是，如果我们封装成一个，好像也不合理∶有些左侧是菜单，有些是返回，有些中间是搜索，有些是文字，等等。

如何封装合适呢?抽取共性，保留不同。

- 最好的封装方式就是将共性抽取到组件中，将不同暴露为插槽。
- 一旦我们预留了插槽，就可以让使用者根据自己的需求，决定插槽中插入什么内容。
- 是搜索框，还是文字，还是菜单。由调用者自己来决定。

这就是为什么我们要学习组件中的插槽slot的原因。

#### 7.12.1 基本使用

![image-20210515190558104](https://i.loli.net/2021/05/18/wrCFWeU4zvZY3j8.png)

效果图：

![image-20210515190642507](https://i.loli.net/2021/05/18/HVwLAIne4gGZt3b.png)

插槽也可以设置默认值：

![image-20210515190813830](https://i.loli.net/2021/05/18/hodNH9LiY4xZct6.png)

效果图：

![image-20210515190821530](https://i.loli.net/2021/05/18/t42gbWAKOX6YpUJ.png)

也可以更改插槽的默认值：

![image-20210515190936797](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091150.png)

效果：

![image-20210515190945764](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091146.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn></cpn>
<!-- 我们在组件里面写其他的东西就可以改变，插槽默认的东西 -->
  <cpn>132321</cpn>
</div>
<template id="cpn">
  <div>
    <h2>我是组件</h2>
    <p>对的，组件</p>
    <!--  slot基本使用  -->
<!--    <slot></slot>-->
    <!--  默认值  -->
    <slot><button>按钮</button></slot>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    components: {
      cpn: {
        template: '#cpn'
      }
    }
  });
</script>
</body>
</html>
```



#### 7.12.2 具名slot

具名插槽,顾名思义,就是有具体名字的插槽,使用时指定替换模板中哪个插槽的内容

就比如说我们用三个按钮

![image-20210515191706868](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524092257.png)

这个时候我想替换中间的按钮，如果我们直接这样去更改按钮的数据的话，会替换所有插槽的内容

![image-20210515191920870](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524092303.png)

![image-20210515191939815](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524092310.png)

这时我们就要使用到具名插槽，具名插槽的使用方法就是给每一个插槽添加一个name属性，我们通过name属性，来更改我们想要更改的插槽

![image-20210515192222612](https://i.loli.net/2021/05/18/8is3vwKJnaLHmW4.png)

![image-20210515192232480](https://i.loli.net/2021/05/18/NdhABECPS1wmqyI.png)

#### 7.12.3  编译的作用域

什么是编译作用域，我们将通过下面一个代码来解释

![image-20210515193808735](https://i.loli.net/2021/05/18/uJilhIHv6a5R9ms.png)

思考：这里的模板里面的内容会显示吗？

答案：会显示

![image-20210515193921697](https://i.loli.net/2021/05/18/HqbB5cCRNMVvmPa.png)



为什么会显示呢？

因为这里面isShow的值来自Vue实例里面的决定的，而不是组件里面的
这个组件是数据Vue实例里面的，所以首要选择的作用域是vue实例

如果不是很明白，那么就在来一个案例

这里button会显示吗？

![image-20210515194437112](https://i.loli.net/2021/05/18/ABJzt2rDERyXNqH.png)



答案是不会显示

这里的isShow的值是来自组件的，不是Vue实例，因为我们定义这个是在组件里面，所以首要选择的作用域当然是组件

![image-20210515194509119](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082523.png)

代码：

```html
<!DOCTYPE html>
<html lang = "en">
<head>
  <meta charset = "UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
<!--  这里面isShow的值来自Vue实例里面的决定的，而不是组件里面的
      因为这个组件是数据Vue实例里面的，所以首要选择的作用域是vue实例
-->
  <cpn v-show="isShow"></cpn>
</div>
<template id="cpn">
  <h2>我是标题</h2>
  <p>哈哈哈哈哈哈</p>
  <!--这里的isShow的值是来自组件的，不是Vue实例，
  因为我们定义这个是在组件里面，所以首要选择的作用域当然是组件-->
  <button v-show="isShow"></button>
</template>
<script src="../js/vue.js"></script>
<script>
  const app = new Vue({
    el: '#app',
    data: {
      message: '你好啊！！！',
      isShow:true
    },
    components:{
      cpn:{
        template:`#cpn`,
        data(){
          return{
            isShow:false
          }
        }
      }
    }
  })
</script>
</body>
</html>
```



#### 7.12.4 作用域插槽

父组件替换插槽的标签,但是内容由子组件来提供的。

我们先提一个需求∶

- 子组件中包括一组数据，比如:pLanguages: ['JavaScript', 'Python', 'Swift', 'Go','C++']
- 需要在多个界面进行展示:
  - 某些界面是以水平方向——展示的，
  - 某些界面是以列表形式展示的，
  - 某些界面直接展示一个数组

- 内容在子组件，希望父组件告诉我们如何展示，怎么办呢?
  - 利用slot作用域插槽就可以了

![image-20210515201927772](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524092418.png)

代码：

```html
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<body>
<div id="app">
  <cpn></cpn>
  <cpn>
<!--  目的是获取子组件中的play  -->
    <template v-slot="slot">
      <span>{{slot.data.join('-')}}</span>
    </template>
  </cpn>
</div>
<template id="cpn">
  <div>
    <slot :data="play">
      <ul>
        <li v-for="item in play">{{item}}</li>
      </ul>
    </slot>
  </div>
</template>
<script src="../js/vue.js"></script>
<script>
  let app = new Vue({
    el: '#app',
    data: {
      message: 'Hello Vue js！'
    },
    components: {
      cpn: {
        template: '#cpn',
        data() {
          return {
            play: ['Java', 'Python', 'Vue']
          }
        },
        // 定义一个方法
        create() {
          this.play.join('-')
        }
      }
    }
  });
</script>
</body>
</html>
```

#### 7.12.5  v-slot（动态插槽名）

但我们学习完 **slot** 和 **slot-scope**这两个在vue3.x已经不在使用了

v-slot使用方法跟slot一样，这里就不在演示

具名插槽在2.6.0 新增新增了一个语法糖的功能，跟 `v-on` 和 `v-bind` 一样，`v-slot` 也有缩写，即把参数之前的所有内容 (`v-slot:`) 替换为字符 `#`。例如 `v-slot:header` 可以被重写为 `#header`：

```html
<!-- v-slot只能在template或者components里使用 -->
  <template id="cpn" v-slot="head">
    <div>
      <p>我是头部</p>
    </div>
  </template>
  <template id="footer" v-slot="footer">
    <div>
      <p>我是低部</p>
    </div>
  </template>
```



也可以使用语法糖写法

```html
<!--   v-slot语法糖写法 # -->
    <template id="cpn" #head>
    <div>
      <p>我是头部</p>
    </div>
  </template>
  <template id="footer" #footer>
    <div>
      <p>我是低部</p>
    </div>
  </template>
```





# Vue CLI

## 1. 什么是Vue CLI

Vue CLI 是一个基于 Vue.js 进行快速开发的完整系统，提供：

- 通过 `@vue/cli` 实现的交互式的项目脚手架。

- 通过 `@vue/cli` + `@vue/cli-service-global` 实现的零配置原型开发。

- 一个运行时依赖 (

  ```
  @vue/cli-service
  ```

  )，该依赖：

  - 可升级；
  - 基于 webpack 构建，并带有合理的默认配置；
  - 可以通过项目内的配置文件进行配置；
  - 可以通过插件进行扩展。

- 一个丰富的官方插件集合，集成了前端生态中最好的工具。

- 一套完全图形化的创建和管理 Vue.js 项目的用户界面。

Vue CLI 致力于将 Vue 生态中的工具基础标准化。它确保了各种构建工具能够基于智能的默认配置即可平稳衔接，这样你可以专注在撰写应用上，而不必花好几天去纠结配置的问题。与此同时，它也为每个工具提供了调整配置的灵活性，无需 eject。



## 2. 安装脚手架

关于旧版本

Vue CLI 的包名称由 `vue-cli` 改成了 `@vue/cli`。 如果你已经全局安装了旧版本的 `vue-cli` (1.x 或 2.x)，你需要先通过 `npm uninstall vue-cli -g` 或 `yarn global remove vue-cli` 卸载它。

Node 版本要求

Vue CLI 4.x 需要 [Node.js](https://nodejs.org/) v8.9 或更高版本 (推荐 v10 以上)。你可以使用 [n](https://github.com/tj/n)，[nvm](https://github.com/creationix/nvm) 或 [nvm-windows](https://github.com/coreybutler/nvm-windows) 在同一台电脑中管理多个 Node 版本。

可以使用下列任一命令安装这个新的包：

```bash
npm install -g @vue/cli
# OR
yarn global add @vue/cli
```



安装之后，你就可以在命令行中访问 `vue` 命令。你可以通过简单运行 `vue`，看看是否展示出了一份所有可用命令的帮助信息，来验证它是否安装成功。



## 3. 创建脚手架

### 1. vue create 项目名

运行以下命令来创建一个新项目：

```bash
vue create hello-world
```

![image-20210516151702688](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091633.png)

1. 默认选择Vue 2.x脚手架
2. 默认选择Vue 3.x脚手架
3. 手动选择要素

我们这里选择手动选择要素，会出现下图配置选项

![image-20210516152027507](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091614.png)



### 2. 选择配置，看个人项目需求

**空格键是选中与取消，A键是全选, 按i是反选**

```css
- Choose Vue version： 选择Vue版本

- Babel：转码器，可以将ES6代码转为ES5代码，从而在现有环境执行。 

- TypeScript： 
TypeScript是一个JavaScript（后缀.js）的超集（后缀.ts）包含并扩展了 	   JavaScript 的语法，需要被编译输出为 JavaScript在浏览器运行

- Progressive Web App (PWA) Support PWA: 渐进式Web应用程序

- Router： 支持 vue-router（vue路由  我们后面会学到）

- Vuex： 支持 vuex （vuex的管理模式 我们后面会学到）

- CSS Pre-processors：CSS 预处理器（如： less、sass）

- Linter / Formatter： 代码风格检查和格式化 （如：ESlint）

- Unit Testing： 单元测试（unit tests）

- E2E Testing：  E2E（end to end) 测试。
```





### 3. 选择一个你想用的Vue.js版本来启动项目

![image-20210516152901339](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091553.png)

这里我选择的是2.x

### 4. 选择是否使用history router

![img](https://img2018.cnblogs.com/blog/735803/201910/735803-20191021104027893-2061265382.png)

 Vue-Router 利用了浏览器自身的hash 模式和 history 模式的特性来实现前端路由（通过调用浏览器提供的接口）。

- 我这里建议选n。这样打包出来丢到服务器上可以直接使用了，后期要用的话，也可以自己再开起来。

- 选yes的话需要服务器那边再进行设置。

  

### 5.  选择css 预处理器

![image-20210516154309360](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524091532.png)

我选择的是Sass/Scss(with dart-sass) 

node-sass是自动编译实时的，dart-sass需要保存后才会生效。sass 官方目前主力推dart-sass 最新的特性都会在这个上面先实现



### 6. 选择Eslint代码验证规则

提供一个插件化的javascript代码检测工具，ESLint + Prettier (使用较多)

![image-20210516154439954](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082540.png)

#### 6.1  选择什么时候进行代码规则检测

![image-20210516154609807](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082537.png)

( ) Lint on save // 保存就检测
( ) Lint and fix on commit // fix和commit时候检查
**建议选择保存就检测，等到commit的时候，问题可能都已经积累很多了**



### 7. 你喜欢把Babel、ESLint等的配置放在哪里？

![image-20210516153216299](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082543.png)

1. 在专用配置文件中
2. 在package.json中

我这里选择package.json

如果是选择 独立文件放置，项目会有单独如下图所示的几件文件。

![img](https://img2018.cnblogs.com/blog/735803/201910/735803-20191021110637371-1323014892.png)

### 8. 是否将此保存为将来项目的预设？

![image-20210516153810232](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082549.png)

键入N不记录，如果键入Y需要输入保存名字，如第2步所看到的我保存的名字为test。

### 9. 安装中

![image-20210516155104565](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082552.png)

## 4. Vue CLI 目录解释

![image-20210516155251437](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082556.png)

### 1. node_modules

所有的第三方依赖，以及安装包

### 2. public

公共资源。
public目录下的资源会被直接复制，不会经过webpack的打包处理。（注：其中空文件夹资源不会被复制，即使使用copy-webpack-plugin也不会）。

### 3. src

所有的项目文件（源码）

#### 3.1 assets

静态资源
通过相对路径被引入，这类引用会被webpack处理。
eg：background: url(’./image.png’)
css,img,js,font等

#### 3.2 component

公共组件，一般自定义组件

#### 3.3 router

路由配置 vue-router

#### 3.4 store

存放vue中的状态数据，用于vuex集中管理

#### 3.5 views

视图组件

#### 3.6 APP.vue

首页组件（默认组件），使用标签渲染整个工程的.vue组建

#### 3.7 main.js

vue-cli工程的入口文件



### 4. 了解即可

#### .browserslistrc（设置浏览器的兼容）

**·初始信息如下**

> 1%
> last 2 versions
> not dead

> 1% ：代表着全球超过1%人使用的浏览器
> last 2 versions ：表示所有浏览器兼容到最后两个版本
> not dead ：通过last 2 versions 筛选的浏览器版本中，全球使用率低于0.5%并且官方申明不再维护或者事实上已经两年没有在更新的版本，不再兼容这些版本。
> **在package.json中配置 而非单独的一个文件**
> 配置信息配置如下
> ![在这里插入图片描述](https://img-blog.csdnimg.cn/202102041835423.png#pic_center)

#### .editorconfig

帮助开发人员在不同的编辑器和IDE（集成开发环境）之间定义和维护一致的编码样式。

```
# 告诉EditorConfig插件，这是根文件，不用继续往上查找root = true
# 匹配全部文件
[*]
# 结尾换行符，可选"lf"、"cr"、"crlf"
end_of_line = lf
# 在文件结尾插入新行
insert_final_newline = true
# 删除一行中的前后空格 
trim_trailing_whitespace = true
# 匹配js和py结尾的文件
[*.{js,py}]
# 设置字符集
charset = utf-8

# 匹配py结尾的文件
[*.py]
# 缩进风格，可选"space"、"tab"
indent_style = space
# 缩进的空格数
indent_size = 4

# 以下匹配，类同
[Makefile]
indent_style = tab# tab的宽度tab_width = 4
# 以下匹配，类同
[lib/**.js]
indent_style = space
indent_size = 2

[{package.json,.travis.yml}]
indent_style = space
indent_size = 2
1234567891011121314151617181920212223242526272829303132
```

⚠️ EditorConfig的匹配规则是从上往下，即先定义的规则优先级比后定义的优先级要高。

#### .eslintrc.js

配置ESLint，语法检查
**默认eslint规则：**

代码末尾不能加分号 ;
代码中不能存在多行空行；
tab键不能使用，必须换成两个空格；
代码中不能存在声明了但未使用的变量；

**Eslint的配置参数**

```
"no-alert": 0,//禁止使用alert confirm prompt
"no-array-constructor": 2,//禁止使用数组构造器
"no-bitwise": 0,//禁止使用按位运算符
"no-caller": 1,//禁止使用arguments.caller或arguments.callee
"no-catch-shadow": 2,//禁止catch子句参数与外部作用域变量同名
"no-class-assign": 2,//禁止给类赋值
"no-cond-assign": 2,//禁止在条件表达式中使用赋值语句
"no-console": 2,//禁止使用console
"no-const-assign": 2,//禁止修改const声明的变量
"no-constant-condition": 2,//禁止在条件中使用常量表达式 if(true) if(1)
"no-continue": 0,//禁止使用continue
"no-control-regex": 2,//禁止在正则表达式中使用控制字符
"no-debugger": 2,//禁止使用debugger
"no-delete-var": 2,//不能对var声明的变量使用delete操作符
"no-div-regex": 1,//不能使用看起来像除法的正则表达式/=foo/
"no-dupe-keys": 2,//在创建对象字面量时不允许键重复 {a:1,a:1}
"no-dupe-args": 2,//函数参数不能重复
"no-duplicate-case": 2,//switch中的case标签不能重复
"no-else-return": 2,//如果if语句里面有return,后面不能跟else语句
"no-empty": 2,//块语句中的内容不能为空
"no-empty-character-class": 2,//正则表达式中的[]内容不能为空
"no-empty-label": 2,//禁止使用空label
"no-eq-null": 2,//禁止对null使用==或!=运算符
"no-eval": 1,//禁止使用eval
"no-ex-assign": 2,//禁止给catch语句中的异常参数赋值
"no-extend-native": 2,//禁止扩展native对象
"no-extra-bind": 2,//禁止不必要的函数绑定
"no-extra-boolean-cast": 2,//禁止不必要的bool转换
"no-extra-parens": 2,//禁止非必要的括号
"no-extra-semi": 2,//禁止多余的冒号
"no-fallthrough": 1,//禁止switch穿透
"no-floating-decimal": 2,//禁止省略浮点数中的0 .5 3.
"no-func-assign": 2,//禁止重复的函数声明
"no-implicit-coercion": 1,//禁止隐式转换
"no-implied-eval": 2,//禁止使用隐式eval
"no-inline-comments": 0,//禁止行内备注
"no-inner-declarations": [2, "functions"],//禁止在块语句中使用声明（变量或函数）
"no-invalid-regexp": 2,//禁止无效的正则表达式
"no-invalid-this": 2,//禁止无效的this，只能用在构造器，类，对象字面量
"no-irregular-whitespace": 2,//不能有不规则的空格
"no-iterator": 2,//禁止使用__iterator__ 属性
"no-label-var": 2,//label名不能与var声明的变量名相同
"no-labels": 2,//禁止标签声明
"no-lone-blocks": 2,//禁止不必要的嵌套块
"no-lonely-if": 2,//禁止else语句内只有if语句
"no-loop-func": 1,//禁止在循环中使用函数（如果没有引用外部变量不形成闭包就可以）
"no-mixed-requires": [0, false],//声明时不能混用声明类型
"no-mixed-spaces-and-tabs": [2, false],//禁止混用tab和空格
"linebreak-style": [0, "windows"],//换行风格
"no-multi-spaces": 1,//不能用多余的空格
"no-multi-str": 2,//字符串不能用\换行
"no-multiple-empty-lines": [1, {"max": 2}],//空行最多不能超过2行
"no-native-reassign": 2,//不能重写native对象
"no-negated-in-lhs": 2,//in 操作符的左边不能有!
"no-nested-ternary": 0,//禁止使用嵌套的三目运算
"no-new": 1,//禁止在使用new构造一个实例后不赋值
"no-new-func": 1,//禁止使用new Function
"no-new-object": 2,//禁止使用new Object()
"no-new-require": 2,//禁止使用new require
"no-new-wrappers": 2,//禁止使用new创建包装实例，new String new Boolean new Number
"no-obj-calls": 2,//不能调用内置的全局对象，比如Math() JSON()
"no-octal": 2,//禁止使用八进制数字
"no-octal-escape": 2,//禁止使用八进制转义序列
"no-param-reassign": 2,//禁止给参数重新赋值
"no-path-concat": 0,//node中不能使用__dirname或__filename做路径拼接
"no-plusplus": 0,//禁止使用++，--
"no-process-env": 0,//禁止使用process.env
"no-process-exit": 0,//禁止使用process.exit()
"no-proto": 2,//禁止使用__proto__属性
"no-redeclare": 2,//禁止重复声明变量
"no-regex-spaces": 2,//禁止在正则表达式字面量中使用多个空格 /foo bar/
"no-restricted-modules": 0,//如果禁用了指定模块，使用就会报错
"no-return-assign": 1,//return 语句中不能有赋值表达式
"no-script-url": 0,//禁止使用javascript:void(0)
"no-self-compare": 2,//不能比较自身
"no-sequences": 0,//禁止使用逗号运算符
"no-shadow": 2,//外部作用域中的变量不能与它所包含的作用域中的变量或参数同名
"no-shadow-restricted-names": 2,//严格模式中规定的限制标识符不能作为声明时的变量名使用
"no-spaced-func": 2,//函数调用时 函数名与()之间不能有空格
"no-sparse-arrays": 2,//禁止稀疏数组， [1,,2]
"no-sync": 0,//nodejs 禁止同步方法
"no-ternary": 0,//禁止使用三目运算符
"no-trailing-spaces": 1,//一行结束后面不要有空格
"no-this-before-super": 0,//在调用super()之前不能使用this或super
"no-throw-literal": 2,//禁止抛出字面量错误 throw "error";
"no-undef": 1,//不能有未定义的变量
"no-undef-init": 2,//变量初始化时不能直接给它赋值为undefined
"no-undefined": 2,//不能使用undefined
"no-unexpected-multiline": 2,//避免多行表达式
"no-underscore-dangle": 1,//标识符不能以_开头或结尾
"no-unneeded-ternary": 2,//禁止不必要的嵌套 var isYes = answer === 1 ? true : false;
"no-unreachable": 2,//不能有无法执行的代码
"no-unused-expressions": 2,//禁止无用的表达式
"no-unused-vars": [2, {"vars": "all", "args": "after-used"}],//不能有声明后未被使用的变量或参数
"no-use-before-define": 2,//未定义前不能使用
"no-useless-call": 2,//禁止不必要的call和apply
"no-void": 2,//禁用void操作符
"no-var": 0,//禁用var，用let和const代替
"no-warning-comments": [1, { "terms": ["todo", "fixme", "xxx"], "location": "start" }],//不能有警告备注
"no-with": 2,//禁用with
"array-bracket-spacing": [2, "never"],//是否允许非空数组里面有多余的空格
"arrow-parens": 0,//箭头函数用小括号括起来
"arrow-spacing": 0,//=>的前/后括号
"accessor-pairs": 0,//在对象中使用getter/setter
"block-scoped-var": 0,//块语句中使用var
"brace-style": [1, "1tbs"],//大括号风格
"callback-return": 1,//避免多次调用回调什么的
"camelcase": 2,//强制驼峰法命名
"comma-dangle": [2, "never"],//对象字面量项尾不能有逗号
"comma-spacing": 0,//逗号前后的空格
"comma-style": [2, "last"],//逗号风格，换行时在行首还是行尾
"complexity": [0, 11],//循环复杂度
"computed-property-spacing": [0, "never"],//是否允许计算后的键名什么的
"consistent-return": 0,//return 后面是否允许省略
"consistent-this": [2, "that"],//this别名
"constructor-super": 0,//非派生类不能调用super，派生类必须调用super
"curly": [2, "all"],//必须使用 if(){} 中的{}
"default-case": 2,//switch语句最后必须有default
"dot-location": 0,//对象访问符的位置，换行的时候在行首还是行尾
"dot-notation": [0, { "allowKeywords": true }],//避免不必要的方括号
"eol-last": 0,//文件以单一的换行符结束
"eqeqeq": 2,//必须使用全等
"func-names": 0,//函数表达式必须有名字
"func-style": [0, "declaration"],//函数风格，规定只能使用函数声明/函数表达式
"generator-star-spacing": 0,//生成器函数*的前后空格
"guard-for-in": 0,//for in循环要用if语句过滤
"handle-callback-err": 0,//nodejs 处理错误
"id-length": 0,//变量名长度
"indent": [2, 4],//缩进风格
"init-declarations": 0,//声明时必须赋初值
"key-spacing": [0, { "beforeColon": false, "afterColon": true }],//对象字面量中冒号的前后空格
"lines-around-comment": 0,//行前/行后备注
"max-depth": [0, 4],//嵌套块深度
"max-len": [0, 80, 4],//字符串最大长度
"max-nested-callbacks": [0, 2],//回调嵌套深度
"max-params": [0, 3],//函数最多只能有3个参数
"max-statements": [0, 10],//函数内最多有几个声明
"new-cap": 2,//函数名首行大写必须使用new方式调用，首行小写必须用不带new方式调用
"new-parens": 2,//new时必须加小括号
"newline-after-var": 2,//变量声明后是否需要空一行
"object-curly-spacing": [0, "never"],//大括号内是否允许不必要的空格
"object-shorthand": 0,//强制对象字面量缩写语法
"one-var": 1,//连续声明
"operator-assignment": [0, "always"],//赋值运算符 += -=什么的
"operator-linebreak": [2, "after"],//换行时运算符在行尾还是行首
"padded-blocks": 0,//块语句内行首行尾是否要空行
"prefer-const": 0,//首选const
"prefer-spread": 0,//首选展开运算
"prefer-reflect": 0,//首选Reflect的方法
"quotes": [1, "single"],//引号类型 `` "" ''
"quote-props":[2, "always"],//对象字面量中的属性名是否强制双引号
"radix": 2,//parseInt必须指定第二个参数
"id-match": 0,//命名检测
"require-yield": 0,//生成器函数必须有yield
"semi": [2, "always"],//语句强制分号结尾
"semi-spacing": [0, {"before": false, "after": true}],//分号前后空格
"sort-vars": 0,//变量声明时排序
"space-after-keywords": [0, "always"],//关键字后面是否要空一格
"space-before-blocks": [0, "always"],//不以新行开始的块{前面要不要有空格
"space-before-function-paren": [0, "always"],//函数定义时括号前面要不要有空格
"space-in-parens": [0, "never"],//小括号里面要不要有空格
"space-infix-ops": 0,//中缀操作符周围要不要有空格
"space-return-throw-case": 2,//return throw case后面要不要加空格
"space-unary-ops": [0, { "words": true, "nonwords": false }],//一元运算符的前/后要不要加空格
"spaced-comment": 0,//注释风格要不要有空格什么的
"strict": 2,//使用严格模式
"use-isnan": 2,//禁止比较时使用NaN，只能用isNaN()
"valid-jsdoc": 0,//jsdoc规则
"valid-typeof": 2,//必须使用合法的typeof的值
"vars-on-top": 2,//var必须放在作用域顶部
"wrap-iife": [2, "inside"],//立即执行函数表达式的小括号风格
"wrap-regex": 0,//正则表达式字面量用小括号包起来
"yoda": [2, "never"]//禁止尤达条件

```

#### .gitignore

上传github时忽略的文件或文件夹

#### babel.config.js

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210204192042964.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NjQxMjIxMw==,size_16,color_FFFFFF,t_70#pic_center)
**Babel是一个JS编译器，主要是将ES5版本的代码转换为向后兼容的JS语法，以便能够运行在当前和旧版本的浏览器或其他环境中。
Vue项目中普遍使用ES6语法，若要求兼容低版本浏览器，就需要引入Babel，将ES6转换为ES5。**

#### package.json

项目描述即依赖

name:项目名称，不能以.或者_开头，不能包含大写字母
version：语义化版本
项目版本号遵循大版本、次要版本、小版本
版本格式：主版本号.次版本号.修订号，版本号递增规则如下：

```
主版本号：当你做了不兼容的 API 修改，
次版本号：当你做了向下兼容的功能性新增，
修订号：当你做了向下兼容的问题修正。
123
```

private：true //是否私有

#### scripts

scripts中的子项即是我们在控制台运行的脚本的缩写

“serve”: “vue-cli-service serve”,
“build”: “vue-cli-service build”,
“lint”: “vue-cli-service lint”

dependencies（项目依赖库）

dependencies：在安装时则使用–save则写入到dependencies。项目运行时用到

#### devDependencies（开发依赖库）

安装时使用 --save-dev将写入到devDependencies

#### gitHooks

#### lint-staged

#### package-lock.json

版本管理使用的文件

#### README.md

项目说明文件





# Vue Loader

一、vue-loader作用：
解析和转换.vue文件。提取出其中的逻辑代码 script,样式代码style,以及HTML 模板template，再分别把他们交给对应的loader去处理
二、用途
js可以写es6,style样式可以写scss或less、template可以加jade等
三、
css-loader：加载由vue-loader提取出的CSS代码
vue-template-compiler：把vue-loader提取出的HTML模板编译成可执行的jacascript代码



想了解详细自己看官网吧：https://vue-loader.vuejs.org/zh/





# Vue Router

## 1. 什么是Vue Router

Vue Router 是 [Vue.js (opens new window)](http://cn.vuejs.org/)官方的路由管理器。它和 Vue.js 的核心深度集成，让构建单页面应用变得易如反掌。包含的功能有：

- 嵌套的路由/视图表
- 模块化的、基于组件的路由配置
- 路由参数、查询、通配符
- 基于 Vue.js 过渡系统的视图过渡效果
- 细粒度的导航控制
- 带有自动激活的 CSS class 的链接
- HTML5 历史模式或 hash 模式，在 IE9 中自动降级
- 自定义的滚动条行为

## 2. 安装Vue Router

1. 安装vue-router

   ```bash
   npm install vue-router
   ```

2. 在模块化工程中使用（因为是一个插件，所以可以通过Vue.use()来安装）

   1. **导入**路由对象，并且**调用Vue.ues(VueRouter)**
   2. 创建**路由实例**，并且传入路由**映射配置**
   3. 在**Vue实例**中**挂载**创建**路由实例**

如果你创建好的项目忘记添加路由了有两种方法解决

- 手动配置

  1. 首先在src目录下创建一个**router**文件夹

  2. 在router文件夹中创建一个**index.js**文件

     编写以下代码

     ```js
     // 配置路由的相关信息
     // 导入Vue和VueRouter(必须导入）
     import Vue from 'vue'
     import VueRouter from 'vue-router'
     // 1.通过Vue.ues(插件), 安装插件
     Vue.use(VueRouter)
     
     // 2.创建VueRouter对象
     const routes = [
     
     ]
     
     const router = new VueRouter({
       // 配置路由和组件之间的应用关系
       routes // (缩写) 相当于 routes: routes
     })
     // 3.将router对象传入到Vue实例中
     export default router
     
     ```

     在main.js中引入

     ![image-20210516170319055](https://i.loli.net/2021/05/18/ZygJOnS1sDcF5ek.png)

     在package.json文件中

     ```json
     dependencies对象中配置
     "vue-router": "^3.2.0"
     
     devDependencies对象中配置
      "@vue/cli-plugin-router": "^4.5.13",
     ```

- 通过命令配置

  ```basic
  vue add router
  ```

  

## 3. 使用Vue Router

### 3.1 如何使用

1. 创建路由组件
2. 配置路由映射：组件和路径映射关系
3. 使用路由：通过<router-link>和<router-view>

首先我们创建两个组件Home和About

![image-20210516172846114](https://i.loli.net/2021/05/18/uPcbgHLETyS1Awn.png)

在组件中写点内容

![image-20210516172908602](https://i.loli.net/2021/05/18/r4VqmJGvcNTD3YF.png)

![image-20210516172916838](https://i.loli.net/2021/05/18/Ka2LludHZfyOJEX.png)

在router文件夹中的index.js文件里配置

![image-20210516173011399](https://i.loli.net/2021/05/18/UDxX6ZC8PRdgIjJ.png)

代码：

```js
// 配置路由的相关信息
// 导入Vue和VueRouter(必须导入）
import Vue from 'vue'
import VueRouter from 'vue-router'
// 导入Home组件和About组件
import Home from '../components/Home'
import About from '../components/About'
// 1.通过Vue.ues(插件), 安装插件
Vue.use(VueRouter)

// 2.创建VueRouter对象
const routes = [
  {
    path: '/home', // 路径
    component: Home // 对应显示的组件名称
  },
  {
    path: '/about',
    component: About
  }
]
// 3.定义路由
const router = new VueRouter({
  // 配置路由和组件之间的应用关系
  routes // (缩写) 相当于 routes: routes
})

// 4.将router对象传入到Vue实例中
export default router

```



在App.vue组件

![image-20210516173143313](https://i.loli.net/2021/05/18/RhLvgp5VTMQn9AC.png)

代码

```vue
<template>
  <div id="app">
    <!-- 使用 router-link 组件来导航. -->
    <!-- 通过传入 `to` 属性指定链接. -->
    <!-- <router-link> 默认会被渲染成一个 `<a>` 标签 -->
    <router-link to="/home">首页</router-link>
    <router-link to="/about">关于</router-link>
    <!-- 路由出口 -->
    <!-- 路由匹配到的组件将渲染在这里 -->
    <router-view></router-view>
  </div>
</template>
<style scoped>
</style>

```



### 3.2 redirect (重定向) 和别名

通过上面的实现我们发现，但我们打开网页的时候，我们的网页没有自动显示首页的内容

![image-20210516190340760](https://i.loli.net/2021/05/18/GWMFUNyCRT4sLkz.png)

这时我们有一个需求，但我们打开网页的时候，网页自动显示首页里的内容，这时我们可以使用**redirect**功能

![image-20210516190719535](https://i.loli.net/2021/05/18/Lko9GytsJn8PeRI.png)

效果：

![image-20210516190742162](https://i.loli.net/2021/05/18/9P54RZjhbU7Akdc.png)

给路由起一个alias

![image-20210517092926514](https://i.loli.net/2021/05/18/TIFwdhPmUEpRz39.png)

效果：

![image-20210517092945692](https://i.loli.net/2021/05/18/RqmFONEj8xy5fkA.png)

### 3.3 history

通过上图我们发现我们的网址路径里面有一个#号，对于强迫症人员来说非常的不友好，我们想要去掉这个#号可以通过**history**来去除

![image-20210516191109685.png](https://i.loli.net/2021/11/18/DTpxPMKtWI5nzdG.png)

![image-20210516191109685](https://i.loli.net/2021/05/18/2gVjJATL51kfBcM.png)

效果：

![image-20210516191126544](https://i.loli.net/2021/05/18/DFRTpGiAz85LU4g.png)



### 3.4 router-link功能

在前面的<router-link>中，我们只是使用了一个属性: to，用于指定跳转的路径.<router-link>还有一些其他属性:

**tag**: tag可以指定<router-link>之后渲染成什么组件，比如上面的代码会被渲染成一个<li>元素,而不是<a>

![image-20210516192247912](https://i.loli.net/2021/05/18/KCDVZULa8BR41X2.png)

效果：

![image-20210516192307198](https://i.loli.net/2021/05/18/8sxk16dOuBt9STl.png)

**replace**： replace不会留下history记录,所以指定replace的情况下,后退键返回不能返回到上一个页面中

![image-20210516192359919](https://i.loli.net/2021/05/18/ZxnmY851rLiIa27.png)



效果：

![image-20210516192339578](https://i.loli.net/2021/05/18/bNipSmfC8X3cnoB.png)

**active-class**:当<router-link>对应的路由匹配成功时,会自动给当前元素设置一个router-link-active的class,设置active-class可以修改默认的名称.

- 在进行高亮显示的导航菜单或者底部tabbar时，会使用到该类.
- 但是通常不会修改类的属性,会直接使用默认的router-link-active即可.



![image-20210516192547725](https://i.loli.net/2021/05/18/Lz79eoMtPvgQKU8.png)

![image-20210516192739266](https://i.loli.net/2021/05/18/hJFKAmj1RlzryaS.png)

效果：

![image-20210516192805000](https://i.loli.net/2021/05/18/fkQDuqdIy1caiRl.png)

通过设置linkActiveClass发现，路由的Class名称被更改了

### 3.5 编程式的导航

除了使用 `<router-link>` 创建 a 标签来定义导航链接，我们还可以借助 router 的实例方法，通过编写代码来实现。

[#](https://router.vuejs.org/zh/guide/essentials/navigation.html#router-push-location-oncomplete-onabort)`router.push(location, onComplete?, onAbort?)`

**注意：在 Vue 实例内部，你可以通过 `$router` 访问路由实例。因此你可以调用 `this.$router.push`。**

想要导航到不同的 URL，则使用 `router.push` 方法。这个方法会向 history 栈添加一个新的记录，所以，当用户点击浏览器后退按钮时，则回到之前的 URL。

当你点击 `<router-link>` 时，这个方法会在内部调用，所以说，点击 `<router-link :to="...">` 等同于调用 `router.push(...)`。

该方法的参数可以是一个字符串路径，或者一个描述地址的对象。例如：

```js
// 字符串
router.push('home')

// 对象
router.push({ path: 'home' })

// 命名的路由
router.push({ name: 'user', params: { userId: '123' }})

// 带查询参数，变成 /register?plan=private
router.push({ path: 'register', query: { plan: 'private' }})
```

**注意：如果提供了 `path`，`params` 会被忽略，上述例子中的 `query` 并不属于这种情况。取而代之的是下面例子的做法，你需要提供路由的 `name` 或手写完整的带有参数的 `path`：**

```js
const userId = '123'
router.push({ name: 'user', params: { userId }}) // -> /user/123
router.push({ path: `/user/${userId}` }) // -> /user/123
// 这里的 params 不生效
router.push({ path: '/user', params: { userId }}) // -> /user
```

同样的规则也适用于 `router-link` 组件的 `to` 属性。



### 3.6 命名路由

有时候，通过一个名称来标识一个路由显得更方便一些，特别是在链接一个路由，或者是执行一些跳转的时候。你可以在创建 Router 实例的时候，在 `routes` 配置中给某个路由设置名称。

![image-20210517091434312](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082805.png)



要链接到一个命名路由，可以给 `router-link` 的 `to` 属性传一个对象：

![image-20210517091503191](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524082809.png)

这跟代码调用 `router.push()` 是一回事：

```js
router.push({ name: 'user', params: { userId: 123 } })
```

这两种方式都会把路由导航到 `/user/123` 路径。



### 3.7 命名试图

有时候想同时 (同级) 展示多个视图，而不是嵌套展示，例如创建一个布局，有 `sidebar` (侧导航) 和 `main` (主内容) 两个视图，这个时候命名视图就派上用场了。你可以在界面中拥有多个单独命名的视图，而不是只有一个单独的出口。如果 `router-view` 没有设置名字，那么默认为 `default`。

```html
<router-view class="view one"></router-view>
<router-view class="view two" name="a"></router-view>
<router-view class="view three" name="b"></router-view>
```

一个视图使用一个组件渲染，因此对于同个路由，多个视图就需要多个组件。确保正确使用 `components` 配置 (带上 s)：

```js
const router = new VueRouter({
  routes: [
    {
      path: '/',
      components: {
        default: Foo,
        a: Bar,
        b: Baz
      }
    }
  ]
})
```



## 4. 动态路由

我们经常需要把某种模式匹配到的所有路由，全都映射到同个组件。

例如，我们有一个 `User` 组件，对于所有 ID 各不相同的用户，都要使用这个组件来渲染。那么，我们可以在 `vue-router` 的路由路径中使用“动态路径参数”(dynamic segment) 来达到这个效果：

![image-20210516202650158](https://i.loli.net/2021/05/19/XARycT9fOioHCu5.png)

现在呢，像 `/user/foo` 和 `/user/bar` 都将映射到相同的路由。

一个“路径参数”使用冒号 `:` 标记。当匹配到一个路由时，参数值会被设置到 `this.$route.params`，可以在每个组件内使用。于是，我们可以更新 `User` 的模板，输出当前用户的 ID：

![image-20210516202731564](https://i.loli.net/2021/05/19/fa9C4k6QA8PbXx3.png)

![image-20210516202947581](https://i.loli.net/2021/05/19/iB9JtVW7ZK6wulE.png)

效果：

![image-20210516202955747](https://i.loli.net/2021/05/19/VwDs4liEuPnBNkz.png)



## 5. 路由懒加载

官方给出了解释:

- 当打包构建应用时，Javascript包会变得非常大，影响页面加载。
- 如果我们能把不同路由对应的组件分割成不同的代码块，然后当路由被访问的时候才加载对应组件，这样就更加高效了

官方在说什么呢?

- 首先,我们知道路由中通常会定义很多不同的页面.
- 这个页面最后被打包在哪里呢?一般情况下，是放在一个js文件中.口但是,页面这么多放在一个js文件中,必然会造成这个页面非常的大.
- 如果我们一次性从服务器请求下来这个页面,可能需要花费一定的时间,甚至用户的电脑上还出现了短暂空白的情况.
- 如何避免这种情况呢?使用路由懒加载就可以了.

路由懒加载做了什么?

- 路由懒加载的主要作用就是将路由对应的组件打包成一个个的js代码块.
- 只有在这个路由被访问到的时候,才加载对应的组件

书写方式：

```js
const Foo = () => import(/* webpackChunkName: "group-foo" */ './Foo.vue')
const Bar = () => import(/* webpackChunkName: "group-foo" */ './Bar.vue')
const Baz = () => import(/* webpackChunkName: "group-foo" */ './Baz.vue')
```



## 6. 嵌套路由

### 6.1 什么是路由嵌套？

路由嵌套，就相当于我们写word的一级目录和二级目录，一级目录可以包含多个二级目录

![image-20210516205455955](https://i.loli.net/2021/05/19/k6QK3JoDAqSO4jN.png)

### 6.2 使用方法

1. 首先创建两个components，并且写上点内容

2. 在router文件中的index.js文件中，某一个路由里添加一个children，在children里配置相关路由

   ![image-20210516211443389](https://i.loli.net/2021/05/19/4A2pCJSYfvVQ6Ue.png)

3. 在要嵌套的父模板里面去配置<router-link>和<router-view>

![image-20210516211715790](https://i.loli.net/2021/05/19/yVa8PY4ilBcnJmj.png)

效果：

![image-20210516211739053](https://i.loli.net/2021/05/19/2B6qKTcRsn7lQN1.png)



## 7. 传递参数

传递参数主要有两种类型：params和query

params的类型:

- 配置路由格式: **/router/:id**
- 传递的方式: **在path后面跟上对应的值**
- 传递后形成的路径: **/router/123, /router/abc**

query的类型:

- 配置路由格式:**/router**,也就是普通配置
- 传递的方式:对象中使用**query的key作为传递方式**
- 传递后形成的路径: **/router?id=123,/router?id=abc**

使用方法：

1. 定义一个component，并且写点内容

2. 在router文件中的index.js文件中配置一个路由

   ![image-20210516214132267](https://i.loli.net/2021/05/19/uOfHQ83P91rL2bR.png)

3. 在App.vue中配置

   ![image-20210516214220972](https://i.loli.net/2021/05/19/Xismt8Z9uA5zgK2.png)

4. ![image-20210516214227983](https://i.loli.net/2021/05/19/zDpuJmf5wNPlMVn.png)

效果图：

![image-20210516214241600](https://i.loli.net/2021/05/19/WsfQH6pjgo1mCzx.png)

## 8 导航守卫

导航守卫就是路由跳转过程中的一些钩子函数，再直白点路由跳转是一个大的过程，这个大的过程分为跳转前中后等等细小的过程，在每一个过程中都有一函数，这个函数能让你操作一些其他的事儿的时机，这就是导航守卫。

用大白话说：简单的说就是保安，这个小区的人让进，不是这个小区的到我这里登记。

导航守卫的作用：**监听路由的进入和离开**

**记住这张图的顺序，对后面的学习有所帮助**

![img](https://pic4.zhimg.com/80/v2-c3a67a5eb0b8da4936a6b57ef8c48783_720w.jpg)

### 8.1 全局前置守卫

```js
router.beforeEach((to, from, next) => {
  // ...
})
```

每个守卫方法接收三个参数：

- **`to: Route`**: 即将要进入的目标 [路由对象](https://router.vuejs.org/zh/api/#路由对象)
- **`from: Route`**: 当前导航正要离开的路由 
- **`next: Function`**: 一定要调用该方法来 **resolve** 这个钩子。执行效果依赖 `next` 方法的调用参数。

我们通过一个案例来进行讲解，我们想点击不同组件，浏览器的标题会有所改变，我们可以使用`created()`来进行实现，如果不知道`created()`去看一下之前的笔记生命周期图片 

![image-20210517104824582](https://i.loli.net/2021/05/19/lryqSPKCamkpRUV.png)

![image-20210517104841756](https://i.loli.net/2021/05/19/5BywkFUgetPIjlO.png)



![image-20210517104709323](https://i.loli.net/2021/05/19/bo2m678iQ1rXd4K.png)  ![image-20210517104719454](https://i.loli.net/2021/05/19/Dc1TzbAkgXGluva.png)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          

我们发现通过这种方式实现，有点麻烦，加入我们有1w个组件都要实现功能，那么我们就要在1w个组件当中去添加这么一行代码，非常的不舒服

所以我们可以使用**全局前置守卫** 

![image-20210517105936705](https://i.loli.net/2021/05/19/gmzB3GvIb9VhweO.png)

![image-20210517110558985](https://i.loli.net/2021/05/19/ABO17VNRaIgxiYW.png)

![image-20210517110825756](https://i.loli.net/2021/05/19/4UlIzydpbHAJui9.png)

![image-20210517110842849](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083019.png)

![image-20210517110917129](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083015.png)

通过上述代码你会发现一个问题，我们首页的标题是undefined，出现这种情况，是以为我们在这个组件中设置了路由嵌套，导致`meta`：{}对象里是一个空对象。但我们发现`matched`这个对象中有一个`meta`对象，并且有值，我们可以通过这个对象就行赋值

![image-20210517111252057](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083003.png)

所以我们可以这样实现

![image-20210517111427077](https://cdn.jsdelivr.net/gh/lengyingmofeng/imgs/imgs/20210524083008.png)

还有些其他守卫，可以自己去看官网作者写笔记写吐了：

https://router.vuejs.org/zh/guide/advanced/navigation-guards.html





# Vuex

## 1. 什么是Vuex

`VueX`是适用于在`Vue`项目开发时使用的状态管理工具。试想一下，如果在一个项目开发中频繁的使用组件传参的方式来同步`data`中的值，一旦项目变得很庞大，管理和维护这些值将是相当棘手的工作。为此，`Vue`为这些被多个组件频繁使用的值提供了一个统一管理的工具——`VueX`。在具有`VueX`的Vue项目中，我们只需要把这些值定义在VueX中，即可在整个Vue项目的组件中使用。



## 2. 安装Vuex

- Npm安装Vuex

  ```shell
  npm install vuex --save
  ```

- 在项目的根目录下新增一个`store`文件夹，在该文件夹内创建index.js

  此时你的项目的`src`文件夹应当是这样的

  ```shell
  │  App.vue
  │  main.js
  │
  ├─assets
  │      logo.png
  │
  ├─components
  │      HelloWorld.vue
  │
  ├─router
  │      index.js
  │
  └─store
         index.js
  ```

如果你创建好的项目忘记添加路由了有两种方法解决

- 手动配置

  1. 首先在src目录下创建一个store文件夹，在store文件中创建index.js文件

  2. 在index.js文件中配置相关信息

     ```js
     import Vue from 'vue'
     import Vuex from 'vuex'
     
     //挂载Vuex
     Vue.use(Vuex)
     
     //创建VueX对象
     const store = new Vuex.Store({
         state:{
             //存放的键值对就是所要管理的状态
             name:'helloVueX'
         }
     })
     // 创建Vuex对象
     const store = new Vuex.Store({
       state: {
           // 存放的键值对就是要管理的状态
           name: 'HelloVuex'
       },
       mutations: {
       },
       actions: {
       },
       modules: {
       }
     })
     
     export default store
     ```
     
  3. 将store挂载到Vue实例中 ，打开main.js文件
  
     ```js
     import Vue from 'vue'
     import App from './App.vue'
     import router from './router'
     // 导入store
     import store from './store'
     
     Vue.config.productionTip = false
     
     new Vue({
       router,
       store,  // 挂载到Vue实例中
       render: h => h(App)
     }).$mount('#app')
     ```
  
     

- 通过命令配置

  ```basic
  vue add vuex
  ```

## 3.  状态管理模式

这个状态自管理应用包含以下几个部分：

- **state**，驱动应用的数据源；
- **view**，以声明方式将 **state** 映射到视图；
- **actions**，响应在 **view** 上的用户输入导致的状态变化。

以下是一个表示“单向数据流”理念的简单示意：

![img](https://vuex.vuejs.org/flow.png)

但是，当我们的应用遇到**多个组件共享状态**时，单向数据流的简洁性很容易被破坏：

- 多个视图依赖于同一状态。
- 来自不同视图的行为需要变更同一状态。

对于问题一，传参的方法对于多层嵌套的组件将会非常繁琐，并且对于兄弟组件间的状态传递无能为力。对于问题二，我们经常会采用父子组件直接引用或者通过事件来变更和同步状态的多份拷贝。以上的这些模式非常脆弱，通常会导致无法维护的代码。

因此，我们为什么不把组件的共享状态抽取出来，以一个全局单例模式管理呢？在这种模式下，我们的组件树构成了一个巨大的“视图”，不管在树的哪个位置，任何组件都能获取状态或者触发行为！

通过定义和隔离状态管理中的各种概念并通过强制规则维持视图和状态间的独立性，我们的代码将会变得更结构化且易维护。

## 4. Vuex的使用

我们现在Vuex设置一个键值

![image-20210517175814055](https://i.loli.net/2021/05/20/BCL6NxVpawHvFAK.png)

打开App.vue

![image-20210517180049293](https://i.loli.net/2021/05/18/unwZ5vaER2L9jeg.png)

效果：

![image-20210517180100636](https://i.loli.net/2021/05/18/8vQsTfqAVMW3a2B.png)

我们也可以使用methods来获取counter

![image-20210517180605954](https://i.loli.net/2021/05/18/1PzjyRhcZsqu7Lp.png)

**注意，请不要在此处更改`state`中的状态的值，后文中将会说明**



## 5. VueX中的核心内容

在VueX对象中，其实不止有`state`,还有用来操作`state`中数据的方法集，以及当我们需要对`state`中的数据需要加工的方法集等等成员。

成员列表：

- state： 存放状态
- mutations： state成员操作
- getters： 加工state成员给外界
- actions： 异步操作
- modules： 模块化状态管理

**`Vuex的工作流程`**

![img](https://upload-images.jianshu.io/upload_images/16550832-20d0ad3c60a99111.png?imageMogr2/auto-orient/strip|imageView2/2/w/701/format/webp)

首先，`Vue`组件如果调用某个`VueX`的方法过程中需要向后端请求时或者说出现异步操作时，需要`dispatch` VueX中`actions`的方法，以保证数据的同步。可以说，`action`的存在就是为了让`mutations`中的方法能在异步操作中起作用。

如果没有异步操作，那么我们就可以直接在组件内提交状态中的`Mutations`中自己编写的方法来达成对`state`成员的操作。注意，前面有提到，不建议在组件中直接对`state`中的成员进行操作，这是因为直接修改(例如：`this.$store.state.name = 'hello'`)的话不能被`VueDevtools`所监控到。

最后被修改后的state成员会被渲染到组件的原位置当中去

### 5.1 State

这个前面我们已经演示过了，这里就不在演示了





### 5.2 Getters

可以对state中的成员加工后传递给外界

Getters中的方法有两个默认参数

- state 当前VueX对象中的状态对象
- getters 当前getters对象，用于将getters下的其他getter拿来用

使用方法：

![image-20210518194327818](https://i.loli.net/2021/05/18/jgGpOs9z5ERJekL.png)

![image-20210518194342533](https://i.loli.net/2021/05/18/XiVTDpesQnPjIrh.png)

效果：

![image-20210518194356092](https://i.loli.net/2021/05/18/ELFNY4VRBePsHpi.png)

### 5.3 Mutations

`mutations`是操作`state`数据的方法的集合，比如对该数据的修改、增加、删除等等。

#### 5.3.1 Mutations使用方法

`mutations`方法都有默认的形参：

(**[state]** **{[payload]}**)

- `state`是当前`VueX`对象中的`state`
- `payload`是该方法在被调用时传递参数使用的

例如，我们编写了一个方法，当被执行时，能把下列中的counter值修改为`'State'`

![image-20210517185231593](https://i.loli.net/2021/05/18/Ci83fvQd5VochU9.png)

而在组件中，我们需要这样去调用这个`mutation`——例如在App.vue的某个`method`中:

![image-20210517185253622](https://i.loli.net/2021/05/18/AskOC7qhaHdg1eY.png)

#### 5.3.2 Mutation传值

在实际生产过程中，会遇到需要在提交某个`mutation`时需要携带一些参数给方法使用。

可以传递单个数据

![image-20210517190741144](https://i.loli.net/2021/05/18/yEIOwmh75uSn6Yf.png)

![image-20210517190755908](https://i.loli.net/2021/05/18/6mjuLovS8erNCGM.png)

效果：

![image-20210517190817139](https://i.loli.net/2021/05/18/hPQsXZ7Dw5pkVAJ.png)

也可以传递过个数据

![image-20210517190844136](https://i.loli.net/2021/05/18/DbL7yInUq9RWhQN.png)

另一种提交方式：

![image-20210517191100590](https://i.loli.net/2021/05/18/jpt2BmSrNquC59J.png)



#### 5.3.3 增删State中的成员

为了配合Vue的响应式数据，我们在`Mutations`的方法中，应当使用Vue提供的方法来进行操作。如果使用`delete`或者`xx.xx = xx`的形式去删或增，则Vue不能对数据进行实时响应。

Vue.set 为某个对象设置成员的值，若不存在则新增

例如对state对象中添加一个age成员

```js
Vue.set(state,"age",15)
```

Vue.delete 删除成员

将刚刚添加的age成员删除

```js
Vue.delete(state,'age')
```





### 5.4 Actions

由于直接在`mutation`方法中进行异步操作，将会引起数据失效。所以提供了Actions来专门进行异步操作，最终提交`mutation`方法。

`Actions`中的方法有两个默认参数

- `context` 上下文(相当于箭头函数中的this)对象
- `payload` 挂载参数
- 由于`setTimeout`是异步操作，所以需要使用`actions`

```js
actions:{
    aEdit(context,payload){
        setTimeout(()=>{
            context.commit('edit',payload)
        },2000)
    }
}
```



在组件中调用:

```js
this.$store.dispatch('aEdit',{age:15})
```



**改进:**

由于是异步操作，所以我们可以为我们的异步操作封装为一个`Promise`对象

```js
    aEdit(context,payload){
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                context.commit('edit',payload)
                resolve()
            },2000)
        })
    }
```

### 5.5 modules

当项目庞大，状态非常多时，可以采用模块化管理模式。Vuex 允许我们将 store 分割成**模块（module）**。每个模块拥有自己的 `state、mutation、action、getter`、甚至是嵌套子模块——从上至下进行同样方式的分割。

```js
modules:{
    a:{
        state:{},
        getters:{},
        ....
    }
}
```

组件内调用模块a的状态：

```js
this.$store.state.a
```

而提交或者`dispatch`某个方法和以前一样,会自动执行所有模块内的对应`type`的方法：

```js
this.$store.commit('editKey')
this.$store.dispatch('aEditKey')
```

模块的细节

- 模块中`mutations`和`getters`中的方法接受的第一个参数是自身局部模块内部的`state`

  ```js
  modules:{
      a:{
          state:{key:5},
          mutations:{
              editKey(state){
                  state.key = 9
              }
          },
          ....
      }
  }
  ```



- `getters`中方法的第三个参数是根节点状态

  ```js
  modules:{
      a:{
          state:{key:5},
          getters:{
              getKeyCount(state,getter,rootState){
                  return  rootState.key + state.key
              }
          },
          ....
      }
  }
  ```

  

- `actions`中方法获取局部模块状态是`context.state`,根节点状态是`context.rootState`

  ```js
  modules:{
      a:{
          state:{key:5},
          actions:{
              aEidtKey(context){
                  if(context.state.key === context.rootState.key){
                      context.commit('editKey')
                  }
              }
          },
          ....
      }
  }
  ```



### 5.6 规范目录结构

如果把整个`store`都放在`index.js`中是不合理的，所以需要拆分。比较合适的目录格式如下：

```shell
store:.
│  actions.js
│  getters.js
│  index.js
│  mutations.js
│  mutations_type.js   ##该项为存放mutaions方法常量的文件，按需要可加入
│
└─modules
        Astore.js
```

对应的内容存放在对应的文件中，和以前一样，在`index.js`中存放并导出`store`。`state`中的数据尽量放在`index.js`中。而`modules`中的`Astore`局部模块状态如果多的话也可以进行细分。



# axios

## 1. 什么是axios

Axios 是一个基于 promise 的 HTTP 库，可以用在浏览器和 node.js 中。

**`特性`**

- 从浏览器中创建 [XMLHttpRequests](https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest)
- 从 node.js 创建 [http](http://nodejs.org/api/http.html) 请求
- 支持 [Promise](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise) API
- 拦截请求和响应
- 转换请求数据和响应数据
- 取消请求
- 自动转换 JSON 数据
- 客户端支持防御 [XSRF](http://en.wikipedia.org/wiki/Cross-site_request_forgery)

## 2. 安装

使用 npm:

```basic
npm install axios
```

使用 bower:

```basic
bower install axios
```

使用 cdn:

```js
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

## 3. 使用方法

执行 `GET` 请求

```js
// 为给定 ID 的 user 创建请求
axios.get('/user?ID=12345')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });

// 上面的请求也可以这样做
axios.get('/user', {
    params: {
      ID: 12345
    }
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
```

执行 `POST` 请求

```js
axios.post('/user', {
    firstName: 'Fred',
    lastName: 'Flintstone'
  })
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
```

执行多个并发请求

```js
function getUserAccount() {
  return axios.get('/user/12345');
}

function getUserPermissions() {
  return axios.get('/user/12345/permissions');
}

axios.all([getUserAccount(), getUserPermissions()])
  .then(axios.spread(function (acct, perms) {
    // 两个请求现在都执行完成
  }));
```

详细请看官方文档：http://www.axios-js.com/zh-cn/docs/uy7