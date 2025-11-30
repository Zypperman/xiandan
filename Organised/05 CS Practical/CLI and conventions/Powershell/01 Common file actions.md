# 01 Common File actions

## File I/O

- `Get-Content <FilePath> -TotalCount <N>` - reading the first N lines of a file
    - `Get-Content C:\Path\To\log.txt -TotalCount 10` - displays the first 10 lines of a file named log.txt

- `<command> | Select-Object -First <N>`
    - get the first N items from the output of another command
    - `Get-Process | Select-Object -First 5` - get the first 5 processes running on your system

- Technically you can fake the `head` function from linux with aliases:

    ```Powershell
    function head {
        PARAM(
            [PARAMETER(ValueFromPipeline)][String]$InputObject,
            [PARAMETER(Mandatory=$true)][int32]$n
        )
        BEGIN {
            [System.Collections.ArrayList]$buffer = @()
        }
        PROCESS {
            $buffer.Add($InputObject) | Out-Null
        }
        END {
            $buffer | Select-Object -First $n
        }
    }
    ```
