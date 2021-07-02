package com.example;

/**
 * 口座を表すクラスです。
 */
public class Account {

    // -------------------------------------------------------------
    // フィールド
    // -------------------------------------------------------------

    /** 名義人 */
    private String ownerName;

    /** 残高 */
    private int balance;

    // -------------------------------------------------------------
    // コンストラクタ
    // -------------------------------------------------------------

    /**
     * コンストラクタです。
     * 
     * <p>すべてのフィールドを初期化します。
     * 
     * @param ownerName 名義人
     * @param balance 残高
     */
    public Account(String ownerName, int balance) {
        // チェック処理
        // 名義人にnullは設定できない
        if (ownerName == null) {
            throw new IllegalArgumentException("名義人がnullです。");
        }
        // 残高にマイナス金額は設定できない
        if (balance < 0) {
            throw new IllegalArgumentException("残高にマイナス金額は設定できません。");
        }

        this.ownerName = ownerName;
        this.balance = balance;
    }

    // -------------------------------------------------------------
    // メソッド
    // -------------------------------------------------------------

    /**
     * 送金処理です。
     * 
     * @param dest 送金先の口座
     * @param amount 送金する金額
     */
    public void transfer(Account dest, int amount) {
        // チェック処理
        // 送金額は1円以上であること
        if (amount < 1) {
            throw new IllegalArgumentException(String.format("送金額は1円以上である必要があります。(amount=%d)", amount));
        }
        // 残高がマイナスになる金額は送金できない
        if (this.balance < amount) {
            throw new IllegalArgumentException(
                    String.format("残高がマイナスになる金額は送金できません。(balance=%d, amount=%d)", this.balance, amount));
        }

        // 自分の残高を減らし、送金先口座の残高を増やす
        this.balance -= amount;
        dest.balance += amount;
    }

    /**
     * 入金処理です。
     * 
     * @param amount 入金する金額
     */
    public void deposit(int amount) {
        // チェック処理
        // 入金額は1円以上であること
        if (amount < 1) {
            throw new IllegalArgumentException(String.format("入金額は1円以上である必要があります。(amount=%d)", amount));
        }

        // 残高を増やす
        this.balance += amount;
    }

    // -------------------------------------------------------------
    // Getter
    // -------------------------------------------------------------

    public String getOwnerName() {
        return this.ownerName;
    }

    public int getBalance() {
        return this.balance;
    }

    // -------------------------------------------------------------
    // Setter
    // -------------------------------------------------------------

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    // public void setBalance(int balance) {
    //     this.balance = balance;
    // }

}
