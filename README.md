# UC‑4: Payslip Print / Download
## What it does
Clones a finalized payslip and saves it as TEXT and PDF without modifying the original.
## Main Steps

- Create original Payslip2
- Clone the payslip before download
- Check DownloadToken (not expired)
- Use FileService to save as .txt and .pdf
- Print saved file paths

## Key Ideas

- Safe usage of a finalized object
- Cloning to avoid modifying original
- Validation before persistence (token expiry)
- Separate file responsibilities in FileService
- 
## Goal
Enable safe print/download of payslips by working on a cloned copy.
