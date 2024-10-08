# springboot-file-chunk-md5

#### 介绍
本项目基于Springboot配合前端webupload实现以下功能：分片上传将大文件分成小块上传，提升可靠性、并行传输和网络效率。断点续传在网络中断时从断点继续上传，避免重新上传。秒传通过文件哈希值判断服务器上是否已有相同文件，存在则无需上传，不存在则继续上传，节省带宽和加快速度。

#### 软件架构

**2.1 前端实现**
相关技术栈 vue、webuploader、elmentui
前端vue使用 [WebUploader](https://github.com/fex-team/webuploader) 等库实现分片上传。具体步骤如下：

1. 使用 WebUploader 初始化上传组件，设置分片大小及其他参数。
2. 在文件分片上传前，计算每个分片的哈希值并发送到服务器。
3. 服务器验证分片的哈希值，返回是否需要上传该分片。
4. 前端根据服务器返回结果，决定是否上传分片。

**2.2 后端实现**

后端可以使用 SpringBoot 提供的文件上传接口来处理分片上传请求。具体步骤如下：

1. 接收并验证前端发送的分片文件及其哈希值。
2. 将分片文件保存到临时目录。
3. 保存分片文件信息（如序号、哈希值等）到数据库。
4. 在接收到所有分片后，合并分片文件为完整文件。

#### 安装教程和使用说明

本项目基于Springboot，jdk版本1.8，mysql版本8.0+，maven版本3.5+，运行前请先配置好数据库连接信息

初始化数据库脚本
src\main\resources\database.sql




