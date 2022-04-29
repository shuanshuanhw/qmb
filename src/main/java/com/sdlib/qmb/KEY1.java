package com.sdlib.qmb;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KEY1 {
    private String m_strSrc;
    private int m_nEncryptMethod;
    private MessageDigest m_md;
    private String m_strKey;
    private byte []m_byteDig;

    public KEY1()
    {
    }

    public String getSrc()
    {
            return m_strSrc;
    }

    public void setSrc(String strSrc)
    {
            m_strSrc = strSrc;
    }

    public int getEncryptMethod()
    {
            return m_nEncryptMethod;
    }

    public void setEncryptMethod(int nEncryptMethod)
    {
            m_nEncryptMethod = nEncryptMethod;
    }

    public String getKey()
    {
            return m_strKey;
    }

    public void setKey(String strKey)
    {
            m_strKey = strKey;
    }

    public String Byte2Hex(byte[] b)
    {
            String hs = "";
            String strtmp = "";
            for(int n=0;n<b.length;n++)
            {
                    strtmp = (Integer.toHexString(b[n] & 0xFF));
                    if(strtmp.length() == 1)
                            hs = hs + "0" + strtmp;
                    else
                            hs = hs + strtmp;
            }
            return hs.toUpperCase();
    }

    public String toHex()
    {
      return Byte2Hex(getByteDig());
    }

    public byte []getByteDig()
    {
      return m_byteDig;
    }

    public void setByteDig(byte []b)
    {
      m_byteDig = b;
    }

    public long genKEY()
    {
            int nEncryptMethod = getEncryptMethod();
            switch(nEncryptMethod)
            {
                    case 1:
                    {
                            try
                            {
                                    m_md = MessageDigest.getInstance("MD5");
                            }
                            catch(NoSuchAlgorithmException e){return 0;}
                            break;
                    }
                    case 2:
                    {
                            try
                            {
                                    m_md = MessageDigest.getInstance("SHA-1");
                            }
                            catch(NoSuchAlgorithmException e){return 0;}
                            break;
                    }
            }

            m_md.update(getSrc().getBytes());
            setByteDig(m_md.digest());
            setKey(getByteDig().toString());

            return 1;
    }
}
