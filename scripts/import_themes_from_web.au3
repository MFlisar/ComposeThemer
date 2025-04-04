#include <Array.au3>
#include <File.au3>
#include <MsgBoxConstants.au3>

; fixed variables
$firefox = "C:\Program Files\Mozilla Firefox\firefox.exe"
$downloadedThemeFolder = "C:\Users\flisar\Downloads"
$downloadedThemeFileName = "material-theme.zip"
$themesFolder = @ScriptDir & "\themes"

; setup
$actionGenerateColorsExtended = true
$actionGenerateThemes = true
$themeFolders = _FileListToArray($themesFolder, "*", $FLTA_FOLDERS)

HotKeySet("{Esc}", "ExitScript")

; ----------------------------
; iterate over all themes and do the work
; ----------------------------

OpenFirefoxTabsColorsMuzAndMTB()

$setColorMatch = false
For $i = 0 To $themeFolders[0] -1

	PrevTab()
	
	$folder = $themeFolders[$i + 1]
	$colorsFile = $themesFolder & "\" & $folder & "\colors.txt"
	$colorsExtendedFile = $themesFolder & "\" & $folder & "\colors_extended.txt"
	
	If $actionGenerateColorsExtended Then

		; 1) read theme variant name and main hex color
		$colors = ReadCSV($colorsFile)
		
		; 2) generate extended colors with muz colors Homepage
		If Not(FileExists($colorsExtendedFile)) Then
		
			GenerateExtendedColorsWithMuzPage($colors, $colorsExtendedFile)
			
		EndIf
		
	EndIf

	NextTab()

	If $actionGenerateThemes Then

		; 3) read extended theme colors
		$colors2 = ReadCSV($colorsExtendedFile)
		
		; 4) download theme file from MTH
		If Not($setColorMatch) Then
			PrepareScrollOnMTBPage()
			SetColorMatchOnMTBPage()
			$setColorMatch = true
		EndIf
		DownloadThemeWithMTBPage($folder, $colors2)

	EndIf
	
Next

MsgBox($MB_SYSTEMMODAL, "Info", "Done")
Exit

; #######################
; FUNKTIONEN
; #######################

Func Init()

	; 1) links klicken für focus
	LeftClickAndSleep(5, 300)
	
	; reload um alles zurückzusetzen
	Send("{F5}")
	Sleep(2000)

	; 2) ganz rauf scrollen
	MouseWheel("up", 500)
	Sleep(500)

	; 3) runter scrollen so dass die input buttons sichtbar sind
	MouseWheel("down", 50)
	Sleep(500)
	
	;4) color match aktivieren
	LeftClickAndSleep(527, 341)
	
EndFunc

Func EnterColorAndCloseDialog($color)

	Send("{TAB}")
	Sleep(500)
	Send($color)
	Sleep(500)
	For $i = 1 To 8
		Send("{TAB}")
	Next
	Send("{ENTER}")
	
EndFunc

Func LeftClickAndSleep($x, $y)

	MouseClick("left", $x, $y, 1)
	Sleep(500)
	
EndFunc

Func ScrollY($dist)

	MouseWheel($MOUSE_WHEEL_DOWN, $dist)
	Sleep(500)
	
EndFunc

Func ReadCSV($file)
	
	 ; Get the file contents
    Local $handle = FileOpen($file, $FO_UTF8)
    Local $sFileData = FileRead($handle)
    ; Get the first line
    Local $sFirstLine = FileReadLine($file, 1)
    ; Create the array using the number of commas in the first line
    Local $asCSV[0][UBound(StringSplit($sFirstLine, ";", 3))]
    ; Fill the array
    _ArrayAdd($asCSV, $sFileData, 0, ";")
	
	return $asCSV
	
EndFunc

Func BringFFToFront()
	WinActivate("[CLASS:MozillaWindowClass]", "")
	WinWaitActive("[CLASS:MozillaWindowClass]", "")
	Sleep(500)
EndFunc

Func NextTab()
	Send("^{TAB}") ; CTRL + TAB
	Sleep(500)
EndFunc

Func PrevTab()
	Send("^+{TAB}") ; CTRL + SHIFT + TAB
	Sleep(500)
EndFunc

Func GoBack()
	Send("{BROWSER_BACK}")
	Sleep(500)
EndFunc

Func ExitScript()
    Exit
EndFunc

Func SetColorOnColorsMuzPage($color)
	LeftClickAndSleep(900, 440)
	Send($color)
	Sleep(500)
	Send("{ENTER}")
	Sleep(500)
EndFunc

Func GetColorsFromColorsMuzPage($variant, $pointX, $pointY)

	LeftClickAndSleep($pointX, $pointY)
	
	Local $x[5] = [486, 700, 913, 1123, 1340]
	
	Local $result[5]
	
	; Farben 1-5 kopieren
	For $i = 0 To Ubound($x) -1
		LeftClickAndSleep($x[$i], 484)
		$c = ClipGet()
		$result[$i] = $c
	Next

	GoBack()
	
	return $result
	
EndFunc

Func SetColorMatchOnMTBPage()

	LeftClickAndSleep(230, 340)

EndFunc

Func PrepareScrollOnMTBPage()

	LeftClickAndSleep(100, 300)
	ScrollY(100)

EndFunc

Func SetColorsOnMTBPage($c1, $c2, $c3)
	SetSingleColorOnMTBPage(415, $c1)
	SetSingleColorOnMTBPage(480, $c2)
	SetSingleColorOnMTBPage(545, $c3)
EndFunc

Func SetSingleColorOnMTBPage($y, $color)
	LeftClickAndSleep(50, $y)
	Send("{TAB}")
	Sleep(100)
	Send($color, 1) ; RAW dann ist # kein Problem!
	Sleep(100)
	For $i = 0 To 7
		Send("{TAB}")
		Sleep(100)
	Next
	Send("{ENTER}")
	Sleep(100)
EndFunc

Func ExportThemeOnMTBPage($fileFrom, $folderTo, $fileTo)

	For $i = 0 To 1
		LeftClickAndSleep(1810, 980)
	Next
	
	Sleep(500)
	LeftClickAndSleep(1840, 980)
	LeftClickAndSleep(1745, 850)
	
	DirCreate($folderTo)
	FileRename($fileFrom, $fileTo)
	Sleep(1500)
	
	LeftClickAndSleep(750, 500)
	LeftClickAndSleep(1660, 980)
	
EndFunc

Func FileRename($s_Source, $s_Destination, $i_Flag = 0)
    Return FileMove($s_Source, $s_Destination, $i_Flag)
EndFunc

Func OpenFirefoxTabsColorsMuzAndMTB()

	$url = "https://colors.muz.li/"
	Run($firefox & " " & $url, "", @SW_MAXIMIZE)
	Sleep(500)

	$url = "https://material-foundation.github.io/material-theme-builder/"
	Run($firefox & " " & $url, "", @SW_MAXIMIZE)
	Sleep(500)

	BringFFToFront()
	
	Sleep(2000)
	
EndFunc

Func GenerateExtendedColorsWithMuzPage($colors, $extendedColorFile)

	Local $variants[5] = ["Analogic", "Mono", "Triade", "Complementary", "Tetrade"]
	Local $variantClickX[5] = [550, 850, 550, 850, 550]
	Local $variantClickY[5] = [460, 460, 650, 650, 800]

	Local $lines[0]
	For $i = 0 To Ubound($colors) -1

		$name = $colors[$i][0]
		$color = $colors[$i][1]
		
		; Farbe auf Homepage auswählen und zur nächsten Seite gehen
		SetColorOnColorsMuzPage($color)
		
		For $j = 0 To Ubound($variants) -1
		
			$variant = $variants[$j]
			$pointX = $variantClickX[$j]
			$pointY = $variantClickY[$j]
		
			$colorsOfVariant = GetColorsFromColorsMuzPage($variant, $pointX, $pointY)
			
			$primary = $colorsOfVariant[0]
			$secondary = $colorsOfVariant[1]
			$tertiary = $colorsOfVariant[2]
			$c4 = $colorsOfVariant[3]
			$c5 = $colorsOfVariant[4]
			
			$line = $name & ";" & $variant & ";" & $primary & ";" & $secondary & ";" & $tertiary & ";" & $c4 & ";" & $c5
			_ArrayAdd($lines, $line)
		
		Next
	  
		GoBack()

	Next

	$fileText = _ArrayToString($lines, @CRLF)
	$hFileOpen = FileOpen($extendedColorFile, $FO_OVERWRITE )
	FileWrite ($hFileOpen, $fileText)
	
EndFunc

Func DownloadThemeWithMTBPage($folder, $colors2)

	For $i = 0 To Ubound($colors2) -1
	
		$name = $colors2[$i][0]
		$variant = $colors2[$i][1]
		
		$c1 = $colors2[$i][2]
		$c2 = $colors2[$i][3]
		$c3 = $colors2[$i][4]
		$c4 = $colors2[$i][5]
		$c5 = $colors2[$i][6]
		
		$fileFrom = $downloadedThemeFolder & "\" & $downloadedThemeFileName
		$folderTo = $themesFolder & "\" & $folder
		$fileTo = $folderTo & "\" & $name & "_" & $variant & ".zip"
		
		If Not(FileExists($fileTo)) Then
	
			PrepareScrollOnMTBPage()
			SetColorsOnMTBPage($c1, $c2, $c3)
			ExportThemeOnMTBPage($fileFrom, $folderTo, $fileTo)
				
		EndIf
		
		If FileExists($fileFrom) Then
			FileDelete($fileFrom)
		EndIf
	
	Next
	
EndFunc