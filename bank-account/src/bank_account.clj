(ns bank-account)

(defn open-account []
  (agent {:balance 0
          :status :active
          :validator nil}))

(defn get-balance [acnt]
  (if (= :active (@acnt :status))
    (@acnt :balance)))

(defn update-balance [acnt amt]
  (send acnt update-in [:balance] + amt)
  ;; wait for all the actions on acnt to conclude
  (await-for 10 acnt))

(defn close-account [acnt]
  (send acnt assoc-in [:status] :inactive)
  ;; wait for all the actions on acnt to conclude
  (await-for 10 acnt))
