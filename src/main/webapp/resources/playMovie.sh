#!/bin/bash
export DISPLAY=:0.0
export VDPAU_DRIVER=sunxi
nohup /usr/bin/mplayer -ao alsa:device=hw=1.0 -vo vdpau -vc ffmpeg12vdpau,ffh264vdpau,ffwmv3vdpau,ffvc1vdpau,ffodivxvdpau -fs -slave -input file=/tmp/mplayer-fifo "$1" 2>> /tmp/mediaplace.log 1>/dev/null &
#nohup /usr/bin/mplayer -slave -input file=/tmp/mplayer-fifo "$1" 2>> /tmp/mediaplace.log 1>/dev/null &
