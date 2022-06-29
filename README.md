# GoPro Video Rename

Recursively renames all GoPro video files matching the 2022 default GoPro video naming format below a given path.

## Use Case

GoPro videos are automatically named with the format `GH<SubVideoNum><VideoNum>` (e.g. `GH01116`).
This means that the first sub-video of video 117 would be named `GH01117` but the second sub-video of video 116 would
be named `GH02116`. This sucks because File Explorer displays files in alphabetic order, so parts of video 117 appear
between sub-videos of video 116 and make watching footage in temporal order a pain.

This program simply renames all GoPro video files from their default format to a new format,
`GH<videoNum><subVideoChar>` (e.g. `GH116A`). As a result, the alphabetic order of the video names matches the
order in which the videos were recorded.

## Download and Usage

1. Go to [releases](https://github.com/xWink/GoProVideoRename/releases/).
2. Download and unzip GoProVideoRename.zip
3. Run the script file for your OS
   - Windows = `run-windows.bat`
   - Mac = `run-mac.sh`
   - Linux = `run-mac.sh`
4. When prompted, enter the path to the folder containing all the GoPro videos you want to rename
