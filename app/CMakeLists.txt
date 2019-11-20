cmake_minimum_required(VERSION 3.4.1)

find_library( log-lib
              log )

set(distribution_DIR ../../../../libs)

add_library(  avcodec
              SHARED
              IMPORTED)
set_target_properties (avcodec
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavcodec-57.so)

add_library(  avfilter
              SHARED
              IMPORTED)
set_target_properties (avfilter
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavfilter-6.so)

add_library(  avformat
              SHARED
              IMPORTED)
set_target_properties (avformat
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavformat-57.so)

add_library(  avutil
              SHARED
              IMPORTED)
set_target_properties (avutil
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libavutil-55.so)


add_library(  swresample
              SHARED
              IMPORTED)
set_target_properties (swresample
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libswresample-2.so)


add_library(  swscale
              SHARED
              IMPORTED)
set_target_properties (swscale
                       PROPERTIES IMPORTED_LOCATION
                       ${distribution_DIR}/${ANDROID_ABI}/libswscale-4.so)


#17以下，编译用
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")

#17NDK编写，编译用
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

include_directories(src/main/cpp/include)

add_library( ffmpegvice
             SHARED
             src/main/cpp/ffmpeg_helloworld.c)

target_link_libraries(ffmpegvice
                      ${log-lib} avcodec avfilter avformat avutil swresample swscale )
